package com.smart.luobo.website.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

public class ServiceByAnnotationConfiguration {

    @Bean
    public ServerList<Server> ribbonServerList(){
        String listOgServers = "www.baidu.com,www.riaway.com,www.jetBrains.com";
        String[] servers = listOgServers.split(",");
        Server[] serversArr = new Server[servers.length];
        for (int i = 0; i < servers.length; i++) {
            serversArr[i] = new Server(servers[i].trim());
        }
        return new StaticServerList<>(serversArr);
    }

    @Bean
    public IRule iniRule(){
        return new RandomRule();
    }
}
