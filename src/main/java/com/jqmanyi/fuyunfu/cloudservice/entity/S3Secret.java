package com.jqmanyi.fuyunfu.cloudservice.entity;

import lombok.Data;

@Data
public class S3Secret {
    private String uuid;
    private String name;
    private String ak;
    private String sk;
}
