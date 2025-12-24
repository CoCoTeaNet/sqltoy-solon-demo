-- demo.sys_log definition

CREATE TABLE `sys_log` (
                           `id` char(26) COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '日志编号',
                           `ip_address` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '请求ip地址',
                           `operator` bigint DEFAULT NULL COMMENT '操作人员',
                           `request_way` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '请求方式',
                           `log_status` tinyint DEFAULT NULL COMMENT '日志状态;0异常 1成功',
                           `log_type` tinyint DEFAULT NULL COMMENT '日志类型：1登录 2操作 ',
                           `api_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL COMMENT '接口请求路径',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           PRIMARY KEY (`id`),
                           KEY `sys_log_request_way_index` (`request_way`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统操作日志表';

