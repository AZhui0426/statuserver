package com.azhui.statuserver.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Yang Zhongwei
 * @date 2021/11/29 15:44
 */
@Configuration
public class HazelcastConfig {

    /*@ConditionalOnMissingBean(name = {"hazelcast"})
    @Bean(name = "hazelcast")
    @Primary
    public HazelcastInstance hazelcastInstance() {
        Config config = new ClasspathXmlConfig("hazelcastxml/hazelcast4.xml");
        return Hazelcast.newHazelcastInstance(config);
    }*/
}
