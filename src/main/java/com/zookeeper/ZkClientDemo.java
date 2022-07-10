package com.zookeeper;

import java.util.List;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.junit.Test;

public class ZkClientDemo{

  @Test
  public void testConn() throws InterruptedException{
    ZkClient zkClient = new ZkClient("127.0.0.1:2181", 20000);

    // 监听状态变化
    zkClient.subscribeStateChanges(new IZkStateListener(){
      @Override
      public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception{
        System.out.println("state:" + keeperState);
      }

      @Override
      public void handleNewSession() throws Exception{
        System.out.println("new session");
      }

      @Override
      public void handleSessionEstablishmentError(Throwable throwable) throws Exception{
        throwable.printStackTrace();
      }
    });

    // 监听子节点发生变化
    zkClient.subscribeChildChanges("/", new IZkChildListener(){
      @Override
      public void handleChildChange(String path, List<String> list) throws Exception{
        System.out.println("watch path:" + path);
        // 输出所有子节点
        list.forEach(str -> {
          System.out.println(str);
        });
      }
    });

    // 创建节点
    zkClient.createPersistent("/abc1", "hello");
    zkClient.createEphemeral("/xyz1", "world");
    zkClient.create("/opq1", "world", CreateMode.EPHEMERAL_SEQUENTIAL);

    String data = zkClient.readData("/abc1");
    System.out.println(data);

    // Thread.sleep(100000);
  }
}