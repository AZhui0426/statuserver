package com.azhui.statuserver.application.demo;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

/**
 * @author Yang Zhongwei
 * @date 2021/11/29
 */
public class HazelcastGetStartServerMaster {

    public static void main(String[] args) {
        // 创建一个 hazelcastInstance实例
        HazelcastInstance instance = com.hazelcast.core.Hazelcast.newHazelcastInstance();
        // 创建集群Map
        IMap<Integer, String> clusterMap = instance.getMap("MyMap");
        clusterMap.put(1, "Hello hazelcast map!");

        // 创建集群Queue
        IQueue<String> clusterQueue = instance.getQueue("MyQueue");
        clusterQueue.offer("Hello hazelcast!");
        clusterQueue.offer("Hello hazelcast queue!");
    }
}
