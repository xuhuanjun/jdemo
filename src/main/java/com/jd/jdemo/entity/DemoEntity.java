package com.jd.jdemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoEntity implements Serializable {
    private Integer id;
    private String name;
}
