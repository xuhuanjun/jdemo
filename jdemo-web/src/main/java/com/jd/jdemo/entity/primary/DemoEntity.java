package com.jd.jdemo.entity.primary;

import com.jd.jdemo.common.dba.domain.BizSimpleBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_demo")
@Data
public class DemoEntity extends BizSimpleBaseEntity {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "int comment 'id'")
    private Integer id;*/
    @Column(name = "name", columnDefinition = "varchar(50) comment '姓名'")
    private String name;
    @Column(name = "address", columnDefinition = "varchar(100) comment '住址'")
    private String address;
}
