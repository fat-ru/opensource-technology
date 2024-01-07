package com.zhuzru.junit;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

/**
 * 功能描述：自定义Launcher(需要引入junit-platform-launcher)
 *
 * @Date 2024/1/7 18:10
 * @Created by zhuzru
 */
public class Junit5CustomLauncher {
    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("com.zhuzru.junit"), selectClass(Junit5Test.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        // 在没有engine的情况下，会报错（这里引入了junit-platform-engine)
        launcher.execute(request);
        listener.getSummary().printTo(new PrintWriter(System.out));
    }
}
