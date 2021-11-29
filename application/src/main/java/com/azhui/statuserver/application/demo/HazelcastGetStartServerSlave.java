package com.azhui.statuserver.application.demo;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

/**
 * @author Yang Zhongwei
 * @date 2021/11/29
 */
public class HazelcastGetStartServerSlave {
    public static void main(String[] args) {
        //创建一个 hazelcastInstance实例
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IMap<Integer, String> clusterMap = instance.getMap("MyMap");
        IQueue<String> clusterQueue = instance.getQueue("MyQueue");

        System.out.println("Map Value:" + clusterMap.get(1));
        System.out.println("Queue Size :" + clusterQueue.size());
        System.out.println("Queue Value 1:" + clusterQueue.poll());
        System.out.println("Queue Value 2:" + clusterQueue.poll());
        System.out.println("Queue Size :" + clusterQueue.size());
    }
}
