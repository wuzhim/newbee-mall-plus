package com.jqmanyi.fuyunfu.cloudservice.game.palworld.kubernetes;


import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

public class KubernetesUtils {
    static {
        System.setProperty("kubeconfig", "/Users/zhimin.wu/.kube/bai3-aliyun.kubeconfig");
    }
    public static final KubernetesClient client = new KubernetesClientBuilder().build();
}
