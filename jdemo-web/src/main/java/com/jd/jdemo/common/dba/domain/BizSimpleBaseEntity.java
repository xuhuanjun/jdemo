package com.jd.jdemo.common.dba.domain;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BizSimpleBaseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "int comment 'id'")
    private Integer id;

    @Version
    @Column(name = "VERSION")
    private Integer version = 0;

    /**
     * 创建方法
     *
     * @return
     */
    public Integer create() {
        this.save();
        return this.id;
    }

    /**
     * 修改方法
     *
     * @return
     */
    public Integer update() {
        this.save();
        return this.id;
    }


    /**
     * 物理删除方法
     */
    public void remove() {
        super.remove();
    }
}
