
package com.example.sqltoy_solon_demo;

import com.example.sqltoy_solon_demo.pojo.SysLog;
import org.noear.solon.annotation.Component;
import org.sagacity.sqltoy.dao.LightDao;
import org.sagacity.sqltoy.model.EntityQuery;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.solon.annotation.Db;

import java.util.List;

@Component
public class QueryService {

    @Db
    private LightDao lightDao;

    public void findOne() {
        SysLog one = lightDao.findOne("sys_log_find_list", new SysLog(), SysLog.class);
    }

    public void find() {
        List<SysLog> list = lightDao.find("sys_log_find_list", new SysLog(), SysLog.class);
    }

    public void findEntity() {
        List<SysLog> list = lightDao.findEntity(SysLog.class, EntityQuery.create().names("operator").values("112233"));
    }

    public void findPage() {
        Page<SysLog> page = lightDao.findPage(new Page<>(1, 10), "sys_log_find_list", new SysLog(), SysLog.class);
    }

    public void findPageEntity() {
        Page<SysLog> page = lightDao.findPageEntity(new Page<>(1, 10), SysLog.class, EntityQuery.create().names("operator").values("112233"));
    }

    public void findTop() {
        List<SysLog> list = lightDao.findTop("sys_log_find_list", new SysLog(), SysLog.class, 12);
    }

    public void findRandom() {
        List<SysLog> list = lightDao.findRandom("sys_log_find_list", new SysLog(), SysLog.class, 12);
    }

}
