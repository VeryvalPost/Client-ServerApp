package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8083); // ���� ������ ������� ����� � ��������� ��������� 0-65536. �� ����� �� ��������� �� ��� ������� - ����������� ������������ ����� 8080
        Socket clientSocket = serverSocket.accept(); // ���� �����������
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        System.out.println("New connection accepted" + "\n" + "���� �����������:" + clientSocket.getPort());
        String name = in.readLine();
        out.println(String.format("Hi %s, your port is %d. Are you child? (yes/no)",
                name, clientSocket.getPort()));
        String answer = in.readLine();

        if (answer.equals("yes")) {
            out.println("Welcome to the kids area, " + name + "! Let's play!");
        } else if (answer.equals("no")) {
            out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
        }
        String quit = in.readLine();
        System.out.println(quit);
        out.println(quit);
    }
}