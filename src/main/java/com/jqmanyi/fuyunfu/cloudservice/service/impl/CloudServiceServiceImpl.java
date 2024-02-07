package com.jqmanyi.fuyunfu.cloudservice.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jqmanyi.fuyunfu.cloudservice.CloudServiceType;
import com.jqmanyi.fuyunfu.cloudservice.DeploymentType;
import com.jqmanyi.fuyunfu.cloudservice.entity.CloudServiceConfig;
import com.jqmanyi.fuyunfu.cloudservice.factory.impl.KubernetesPalworldServiceFactory;
import com.jqmanyi.fuyunfu.cloudservice.instance.CloudServiceInstance;
import com.jqmanyi.fuyunfu.cloudservice.instance.impl.PalworldKubernetesInstance;
import com.jqmanyi.fuyunfu.cloudservice.service.CloudServiceService;
import com.jqmanyi.fuyunfu.cloudservice.dao.CloudServiceConfigMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CloudServiceServiceImpl implements CloudServiceService {

    @Autowired
    private KubernetesPalworldServiceFactory kubernetesPalworldServiceFactory;
    @Resource
    private CloudServiceConfigMapper cloudServiceConfigMapper;

    @Autowired
    public CloudServiceServiceImpl service;

    private LoadingCache<String, CloudServiceInstance> serviceInstances =
            CacheBuilder.newBuilder().build(new CacheLoader<String, CloudServiceInstance>() {
                @Override
                public CloudServiceInstance load(String serviceConfigId) throws Exception {
                    return service.createInstance(serviceConfigId);
                }
            });

    public CloudServiceInstance createInstance(String serviceConfigId) {
        CloudServiceConfig cloudServiceConfig =
                cloudServiceConfigMapper.selectByPrimaryKey(serviceConfigId);
        if (cloudServiceConfig.getCloudServiceType() == CloudServiceType.GAMESERVER
                && cloudServiceConfig.getDeploymentType() == DeploymentType.KUBERNETES) {
            return kubernetesPalworldServiceFactory.create(cloudServiceConfig);
        }
        return null;
    }


    @Override
    public Boolean startCloudService(String serviceConfigId) {
        CloudServiceInstance cloudService;
        try {
            cloudService = serviceInstances.get(serviceConfigId);
            return cloudService.start();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
