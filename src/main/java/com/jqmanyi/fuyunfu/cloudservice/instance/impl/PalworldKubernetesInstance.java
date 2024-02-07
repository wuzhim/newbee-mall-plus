package com.jqmanyi.fuyunfu.cloudservice.instance.impl;

import com.jqmanyi.fuyunfu.cloudservice.entity.CloudServiceConfig;
import com.jqmanyi.fuyunfu.cloudservice.entity.S3Secret;
import com.jqmanyi.fuyunfu.cloudservice.instance.CloudServiceInstance;
import lombok.Data;

@Data
public class PalworldKubernetesInstance implements CloudServiceInstance {

    private CloudServiceConfig serviceConfig;
    private S3Secret secret;

    @Override
    public boolean start() {
        return false;
    }
}
