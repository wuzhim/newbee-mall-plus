package com.jqmanyi.fuyunfu.cloudservice.factory.impl;

import com.jqmanyi.fuyunfu.cloudservice.dao.S3SecretMapper;
import com.jqmanyi.fuyunfu.cloudservice.entity.CloudServiceConfig;
import com.jqmanyi.fuyunfu.cloudservice.factory.CloudServiceFactoryInterface;
import com.jqmanyi.fuyunfu.cloudservice.instance.CloudServiceInstance;
import com.jqmanyi.fuyunfu.cloudservice.instance.impl.PalworldKubernetesInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KubernetesPalworldServiceFactory implements CloudServiceFactoryInterface {

    @Autowired
    S3SecretMapper mapper;

    @Override
    public CloudServiceInstance create(CloudServiceConfig config) {
        PalworldKubernetesInstance kubernetesInstance = new PalworldKubernetesInstance();
        kubernetesInstance.setServiceConfig(config);
        kubernetesInstance.setSecret(mapper.selectByPrimaryKey(config.getS3SecretId()));
        return kubernetesInstance;
    }
}
