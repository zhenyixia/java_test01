package com.lyp.netprogramme;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP协议接收数据
 * 创建接收端Socket对象
 * 接收数据
 * 解析数据
 * 使用数据，比如目前只用输出
 * 释放资源
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {

        //需要指定 发送方的端口号，不然无法接收
        DatagramSocket ds = new DatagramSocket(8888);

        //  DatagramPacket(byte buf[], int length)
        byte[] bytes = new byte[1024]; // 实际保存数据的容器
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        System.out.println("接收前--------------");
        ds.receive(dp); //这里是一个阻塞，如果收不到数据不会往下走
        System.out.println("接收后--------------");


        InetAddress address = dp.getAddress();
        byte[] data = dp.getData();
        int length = dp.getLength();  //实际收到的数据的长度，即字节数组的长度


        System.out.println("send from --" + address.getHostAddress());

        //直接构造不指定长度，则接收的数据如果实际为10，也会构造一个长1024的字符串
        System.out.println("content -- " + new String(data));

        //所以需要使用以下
        System.out.println("content -- " + new String(data, 0, length));

        //另外使用先前定义的字节数组容器也可以获取内容，如：
        System.out.println("byte content -- " + new String(bytes, 0, length));


    }
}
