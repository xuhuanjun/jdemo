package com.jd.jdemo.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoResponse implements Serializable {
    private Integer id;
    private String name;
    private String address;
}
