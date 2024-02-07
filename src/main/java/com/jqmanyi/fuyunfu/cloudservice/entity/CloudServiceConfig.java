package com.jqmanyi.fuyunfu.cloudservice.entity;

import com.jqmanyi.fuyunfu.cloudservice.CloudServiceType;
import com.jqmanyi.fuyunfu.cloudservice.DeploymentType;
import lombok.Data;

@Data
public class CloudServiceConfig {
    private String uuid;
    private String name;
    private String nameSpace;
    private String s3SecretId;
    private CloudServiceType cloudServiceType;
    private DeploymentType deploymentType;
}
