package com.gmm.myitem.inetitem;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress name = InetAddress.getByName("192.168.20.152");

        String hostName = name.getHostName();

        String hostAddress = name.getHostAddress();

        System.out.println("主机名称："+hostName+"主机地址:"+hostAddress);


    }
}
