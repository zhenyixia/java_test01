package com.lyp.netprogramme;

import javax.net.ssl.SSLServerSocket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp 服务端 ，有几个特征：
 * 1，需要一直起着，等待别人来连接
 * 2，起着时需要去监听是否有访问
 * 3，有专门的服务端类： ServerSocket
 */
public class TCPServerDemo {

    public static void main(String[] args) throws IOException {
//        server1();
//        server2();
        loginServer();

    }

    public static void server1() throws IOException {
        //创建服务端连接，指定端口号，用于让客户端访问
        ServerSocket ss = new ServerSocket(9999);

        //监听客户端发送的socket连接
        Socket socket = ss.accept();

        //定义字节数组容器，用于接收数据
        byte[] bytes = new byte[1024];

        InputStream is = socket.getInputStream();
        int length = is.read(bytes); //实际读取的字节数长度

        String result = new String(bytes, 0, length);
        System.out.println("服务端接收到的信息： " + result);

        //关闭资源
//        socket.close();

//        ss.close();//可不关，一直保持着服务端开着，随时可以接收访问
    }


    //接收数据后再发送数据
    public static void server2() throws IOException {
        //创建服务端连接，指定端口号，用于让客户端访问
        ServerSocket ss = new ServerSocket(9999);

        //监听客户端发送的socket连接
        Socket socket = ss.accept();

        //定义字节数组容器，用于接收数据
        byte[] bytes = new byte[1024];

        InputStream is = socket.getInputStream();
        int length = is.read(bytes); //实际读取的字节数长度

        String result = new String(bytes, 0, length);
        System.out.println("服务端接收到的信息： " + result);

        //将接收的数据 转换为大写返回给客户端
        result = result.toUpperCase();
        OutputStream os = socket.getOutputStream();
        os.write(result.getBytes());

        //关闭资源
//        socket.close();

//        ss.close();//可不关，一直保持着服务端开着，随时可以接收访问
    }

    public static void loginServer() throws IOException {
        //创建服务端连接，指定端口号，用于让客户端访问
        ServerSocket ss = new ServerSocket(8888);

        //监听客户端发送的socket连接
        Socket socket = ss.accept();

        BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String name = serverReader.readLine();
        String pwd = serverReader.readLine();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        if ("good".equals(name) && "123".equals(pwd)) {
            out.println("登陆成功");
        } else {
            out.println("登陆失败");
        }
        socket.close();
//        ss.close();
    }
}
