package com.jqmanyi.fuyunfu.cloudservice.dao;

import com.jqmanyi.fuyunfu.cloudservice.entity.S3Secret;

public interface S3SecretMapper {
    S3Secret selectByPrimaryKey(String id);
}
