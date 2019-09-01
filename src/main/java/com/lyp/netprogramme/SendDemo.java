package com.lyp.netprogramme;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 基于UDP协议 发送数据 步骤：
 * 1，创建发送socket对象 发送在大小限制在64B
 * 2，创建数据 并打包
 * 3，发送数据
 * 4，释放资源
 * <p>
 * 使用到的类：DatagramSocket datagram： 电子报
 * 构造方法：
 * DatagramSocket() 创建socket对象，并随机指定端口号 ，发给别人只需要知道别人的端口号就行，自己的无所谓
 * DatagramSocket(int port) 创建指定端口号的socket对象。
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        //打包 主要使用DatagramPacket类， 下面的构建方法
        // DatagramPacket(byte buf[], int length,InetAddress address, int port)

        // 要素： 1，数据 要转成字节数组； 2，字节数组长度； 3，ip，4，端口
        String data = "hello world,I'm liyapeng";
        byte[] datas = data.getBytes();
        int length = datas.length;
        InetAddress address = InetAddress.getLocalHost();
        int port = 8888;

        //构造数据报文
        DatagramPacket dp = new DatagramPacket(datas, length, address, port);

        //发送数据
        ds.send(dp);

        //关闭资源
        ds.close();


    }

}
