package com.hey_there.InetProgramming.SimpleSocketIODemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class GreetingServer {
    public static void main(String[] args) {
        int port = 4399;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
        } catch (SocketException se) {
            System.out.println("设置超时时长，发生SocketException");
            return;
        } catch (IOException e) {
            System.out.println("初始化ServerSocket时发生IOException");
            return;
        }

        while (true) {
            try {
                System.out.println("等待远程主机连接，端口号 " + serverSocket.getLocalPort());

                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thanks for connecting, goodbye.");

                server.close();
            } catch (SocketTimeoutException timeout) {
                System.out.println("Socket timeout!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
