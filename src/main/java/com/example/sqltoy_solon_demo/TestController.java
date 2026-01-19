package com.example.sqltoy_solon_demo;

import com.example.sqltoy_solon_demo.pojo.SysLog;
import com.example.sqltoy_solon_demo.pojo.UuidVerSeven;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Path;
import org.noear.solon.core.handle.Context;
import org.sagacity.sqltoy.dao.LightDao;
import org.sagacity.sqltoy.solon.annotation.Db;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Db
    private LightDao lightDao;

    @Get
    @Mapping("/syslog/findAll")
    public List<SysLog> findAll() {
        Map<String, Object> params = new HashMap<>();
        List<SysLog> list = lightDao.find("sys_log_find_list", params, SysLog.class);
        return list;
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

    @Get
    @Mapping("/uuidv7")
    public Object uuidv7() {
        for (int i = 0; i < 50; i++) {
            lightDao.save(new UuidVerSeven().setSort(i));
        }
        return "ok.";
    }

}
