package com.zookeeper;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZkMain{

  // 连接地址及端口号 可以为集群形式，如： 127.0.0.1:2181;128.0.0.1:2181
  public static final String SERVER_HOST = "127.0.0.1:2181";

  // 会话超时时间
  public static final int SESSION_TIME_OUT = 2000;

  private static ZooKeeper zooKeeper;

  private String node = "/test1";

  private String content = "/content1";

  @BeforeClass
  public static void init(){

    try{
      zooKeeper = new ZooKeeper(SERVER_HOST, SESSION_TIME_OUT, new Watcher(){
        @Override
        public void process(WatchedEvent watchedEvent){

          String path = watchedEvent.getPath();
          System.out.println("发生变更的节点路径：" + path);

          // 获取事件状态
          KeeperState state = watchedEvent.getState();
          System.out.println("节点状态： " + state);

          //判断是否为连接事件
          if(KeeperState.SyncConnected == state){
            // 事件类型 分为 None（只有连接），创建，删除，变更，变更子节点
            EventType type = watchedEvent.getType();
            System.out.println("事件类型： " + type);
            if(EventType.None == type){
              System.out.println("zk 客户端已连接...");
            }
          }
        }
      });
    }catch(IOException e){
      System.out.println("操作失败：" + e.getMessage());
      e.printStackTrace();
    }
  }

  @Test
  public void create1() throws KeeperException, InterruptedException{

    System.out.println("============开始创建==============\r\n");

    // 创建一个持久性ZNode，路径是/java，值为Hello World
    if(watchQuery()){
      System.out.println("当前节点：" + node + "已存在。");
      return;
    }
    System.out.println("创建节点：" + node + ", 节点内容为： " + content);
    zooKeeper.create(node, content.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    /**
     * 参数解释：
     * path ZNode路径
     * data ZNode存储的数据
     * acl ACL权限控制
     * createMode ZNode类型
     *
     * 其中： ACL权限控制，有三个是ZooKeeper定义的常用权限，在ZooDefs.Ids类中：
     * OPEN_ACL_UNSAFE  完全开放的ACL，任何连接的客户端都可以操作该属性znode
     * CREATOR_ALL_ACL  只有创建者才有ACL权限
     * READ_ACL_UNSAFE  只能读取ACL
     *
     */

    // System.out.println(s);
    System.out.println("============创建结束==============\r\n");
    // zooKeeper.close();
    // query();
  }

  // 普通查询
  public boolean query() throws KeeperException, InterruptedException{
    System.out.println("============开始查询==============\r\n");

    // 获取 节点数据
    Stat stat = new Stat();
    byte[] data = zooKeeper.getData(node, false, stat);
    if(data == null || data.length == 0){
      System.out.println("当前节点： " + node + " 不存在。");
      return false;
    }
    System.out.println("查询节点" + node + ": " + new String(data));// Hello World
    // System.out.println(stat.getDataLength()); // 11 ,即"Hello World"的长度
    System.out.println("============查询结束==============\r\n");
    return true;
  }

  // 监控查询，当节点有变化时，就会打印相关信息
  public boolean watchQuery() throws KeeperException, InterruptedException{
    System.out.println("============开始监控查询==============\r\n");

    // 获取 节点数据
    Stat stat = new Stat();
    byte[] data = zooKeeper.getData(node, watchEvent -> {

      System.out.println("路径：" + watchEvent.getPath());
      System.out.println("节点状态：" + watchEvent.getState());
      System.out.println("事件类型：" + watchEvent.getType());
    }, null);
    if(data == null || data.length == 0){
      System.out.println("当前节点： " + node + " 不存在。");
      return false;
    }
    System.out.println("查询节点" + node + ": " + new String(data));// Hello World
    // System.out.println(stat.getDataLength()); // 11 ,即"Hello World"的长度
    System.out.println("============监控查询结束==============\r\n");
    return true;
  }

  @Test
  public void setData3() throws KeeperException, InterruptedException{
    System.out.println("============开始设置==============\r\n");
    // 指定version为-1，表示不关心版本
    System.out.println("设置节点值为： 456");
    zooKeeper.setData(node, "456".getBytes(), -1);
    // 设置两次，第二次不会触发通知
    System.out.println("设置节点值为： 789");
    zooKeeper.setData(node, "789".getBytes(), -1);
    Thread.sleep(1000);
    System.out.println("============设置结束==============\r\n");
    // query();
  }

  @AfterClass
  public static void close4() throws InterruptedException{
    System.out.println("关闭节点连接");
    zooKeeper.close();
  }
}