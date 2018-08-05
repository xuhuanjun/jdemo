package com.jd.jdemo.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoRequest implements Serializable {
    private Integer id;
    private String name;
}
