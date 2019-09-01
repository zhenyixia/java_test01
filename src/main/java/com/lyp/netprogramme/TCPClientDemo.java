package com.lyp.netprogramme;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP 发送端 也叫 客户端。而接收端也叫服务端
 * TCP需要建立连接才能发送，且发送不限长度
 * 建立连接使用 Socket，步骤：
 * 1，建立连接 需要知道服务端的ip和端口才能建立
 * 2，获取发送对象，并将数据写入，这里的发送对象即为IO流，
 * 只不过是在Socekt上的输出流，而不是在本地文件上的输出流
 * 3，关闭资源 a，关闭io流； b，关闭socket连接； 其中关闭io流可以省略，因为关闭socket时会自动关io流
 */
public class TCPClientDemo {

    public static void main(String[] args) throws IOException {
//        client1();
//        client2();
        login();

    }

    public static void client1() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream os = socket.getOutputStream();
        String str = "hello tcp,I am comming...";
        os.write(str.getBytes());
        os.close();
        socket.close();
    }

    //发送数据后接收数据
    public static void client2() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream os = socket.getOutputStream();
        String str = "hello tcp,I am comming...";
        os.write(str.getBytes());

        //接收从服务端发来的数据
        InputStream in = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int length = in.read(bytes);

        System.out.println(new String(bytes, 0, length));


        os.close();
        socket.close();
    }

    //模拟登陆
    public static void login() throws IOException {
        //创建连接
        Socket socket = new Socket("lyp-computer", 8888);

        //让客户输入用户名密码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String userName = bufferedReader.readLine();
        System.out.println("请输入密码：");
        String password = bufferedReader.readLine();

        //获取输出流对象
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        //写出数据 注意不是：write 看源码可知：1，println 相当于print() + println
        //而print相当于writer，println调用newLine,该方法相当于写入一个换行符，并且flush一次
        out.println(userName);
        out.println(password);


        //获取返回数据 先获取输入流，再使用bufferReader读取字符流，再获取结果 而不是使用先前的字节数组容器来获取
        BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = serverReader.readLine();
        System.out.println(result);

        //关闭资源
        socket.close();
    }
}
