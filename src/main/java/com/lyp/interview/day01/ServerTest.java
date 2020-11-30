package com.lyp.interview.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class ServerTest {
  public static void main(String[] args) throws Exception {


    //byte ipAddressTemp[] = {127, 0, 0, 1};
    //InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

    //首先直接创建server socket
    int port = 4000;
    ServerSocket serverSocket = new ServerSocket(port);

    //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
    Socket socket = serverSocket.accept();

    //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

    String readLine = null;
    while (!Objects.equals(readLine, "bye")) {

      String inTemp = socketIn.readLine();
      System.out.println("Client:" + "\n" + inTemp);

      System.out.println("Server:");
      readLine = systemIn.readLine();

      socketOut.println(readLine);
      socketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)

      //outTemp = readline;

      //System.out.println(server);

    }

    systemIn.close();
    socketIn.close();
    socketOut.close();
    socket.close();
    serverSocket.close();
  }
}
