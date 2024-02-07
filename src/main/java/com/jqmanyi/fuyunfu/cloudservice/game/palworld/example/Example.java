package com.jqmanyi.fuyunfu.cloudservice.game.palworld.example;




import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;


public class Example {
    public static void main(String[] args) {
        System.setProperty("kubeconfig", "/Users/zhimin.wu/.kube/bai3-aliyun.kubeconfig");
        KubernetesClient client = new KubernetesClientBuilder().build();
        NamespaceList list = client.namespaces().list();
        Secret secret = client.secrets().list().getItems().get(0);
        for (Namespace item : list.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
        client.close();
    }
}
