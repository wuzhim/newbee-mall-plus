package com.jqmanyi.fuyunfu.cloudservice.dao;

import com.jqmanyi.fuyunfu.cloudservice.entity.CloudServiceConfig;

public interface CloudServiceConfigMapper {
    CloudServiceConfig selectByPrimaryKey(String id);
}
