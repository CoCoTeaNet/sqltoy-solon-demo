package com.example.sqltoy_solon_demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sagacity.sqltoy.config.annotation.Column;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Types;

@Data
@Accessors(chain = true)
@Entity(tableName = "uuid_ver_seven", comment = "uuidv7验证表", pk_constraint = "PRIMARY")
public class UuidVerSeven implements Serializable {

    @Serial
    private static final long serialVersionUID = -292170286830969L;

    @Id(strategy = "generator", generator = "org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name = "id", comment = "", length = 36L, type = Types.VARCHAR, nullable = false)
    private String id;

    @Column(name = "sort", comment = "", type = Types.INTEGER, nullable = false)
    private Integer sort;

}
