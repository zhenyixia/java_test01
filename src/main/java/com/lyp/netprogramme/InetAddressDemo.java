package com.lyp.netprogramme;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        String hostName = "lyp-computer";
        String ip = "192.168.1.20";
        InetAddress inetAddress = InetAddress.getByName(hostName); //通过主机名获取
        System.out.println(inetAddress);

        inetAddress = InetAddress.getByName(ip); //通过ip获取
        System.out.println(inetAddress);

        String address = inetAddress.getHostAddress(); //直接获取本机
        hostName =inetAddress.getHostName();

        System.out.println(address);
        System.out.println(hostName);

        inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        address = inetAddress.getHostAddress();
        hostName = inetAddress.getHostName();

        System.out.println(address);
        System.out.println(hostName);


    }

}
