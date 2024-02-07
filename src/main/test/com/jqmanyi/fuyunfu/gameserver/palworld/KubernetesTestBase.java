package com.jqmanyi.fuyunfu.gameserver.palworld;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class KubernetesTestBase {
    static String defaultNameSpace = "fuyunfu-ut";
    static String testKubernetesConfig = "/Users/zhimin.wu/.kube/bai3-aliyun.kubeconfig";
    @BeforeAll
    public static void before() throws IOException {

    }

    @AfterAll
    public static void after() {
    }
}
