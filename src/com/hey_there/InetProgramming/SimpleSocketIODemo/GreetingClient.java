package com.hey_there.InetProgramming.SimpleSocketIODemo;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetingClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 4399;
        Socket client = null;

        try {
            System.out.println("连接到主机：" + serverHost + " ，端口号：" + serverPort);
            try {
                client = new Socket(serverHost, serverPort);
            } catch (ConnectException ce) {
                System.out.println("服务器拒绝连接");
                return;
            }

            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            //获取数据输出流
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            //向server传输数据
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //从server接收数据
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());

            //关闭Socket
            client.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
