package com.jqmanyi.fuyunfu.cloudservice.factory;

import com.jqmanyi.fuyunfu.cloudservice.entity.CloudServiceConfig;
import com.jqmanyi.fuyunfu.cloudservice.instance.CloudServiceInstance;

public interface CloudServiceFactoryInterface {
    CloudServiceInstance create(CloudServiceConfig config);
}
