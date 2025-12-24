package com.example.sqltoy_solon_demo;

import com.example.sqltoy_solon_demo.pojo.SysLog;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Path;
import org.noear.solon.core.handle.Context;
import org.sagacity.sqltoy.dao.LightDao;
import org.sagacity.sqltoy.solon.annotation.Db;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
public class TestController {

    @Db
    private LightDao lightDao;

    @Get
    @Mapping("/order/findAll")
    public Object query() {
        return lightDao.find("findAll", new HashMap<>());
    }

    @Get
    @Mapping("/syslog/{method}")
    public Object syslog(@Path String method, Context context) {
        SysLog sysLog = new SysLog().setApiPath("/syslog")
                .setRequestWay(method)
                .setCreateTime(LocalDateTime.now())
                .setIpAddress(context.realIp());
        return lightDao.save(sysLog);
    }

}
