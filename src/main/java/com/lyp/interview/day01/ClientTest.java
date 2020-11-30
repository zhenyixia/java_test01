package com.lyp.interview.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

public class ClientTest {

  public static void main(String[] args) {
    try {
      byte ipAddressTemp[] = {127, 0, 0, 1};
      InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);

      //首先直接创建socket,端口号1~1023为系统保存，一般设在1023之外
      int port = 4000;
      Socket socket = new Socket(ipAddress, port);

      //创建三个流，系统输入流BufferedReader systemIn，
      // socket输入流BufferedReader socketIn，
      // socket输出流PrintWriter socketOut;
      BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

      String readLine = null;
      while (!Objects.equals(readLine, "bye")) {
        System.out.println("Client:");
        readLine = systemIn.readLine();
        socketOut.println(readLine);
        socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

        String inTemp = socketIn.readLine();
        System.out.println("Server:" + "\n" + inTemp);
      }

      systemIn.close();
      socketIn.close();
      socketOut.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
