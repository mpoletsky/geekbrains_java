package ru.poletskiy.se.lesson26.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoChatServer {
    private ServerSocket serv = null;
    private Socket sock = null;
    private Scanner sc = null;
    private PrintWriter pw = null;

    public static void main(String[] args) {
        EchoChatServer server = new EchoChatServer();
        server.mainMethod();
    }
    private void mainMethod() {
        try {
            serv = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился!");
            sc = new Scanner(sock.getInputStream());
            pw = new PrintWriter(sock.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = sc.nextLine();
                            if (!str.equals("end")) {
                                System.out.println(str);
                            } else {
                                pw.println("end session");
                                pw.flush();
                                System.exit(0);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true) {
                Scanner myscan = new Scanner(System.in);
                String servMessage = myscan.nextLine();
                pw.println(servMessage);
                pw.flush();
            }

//            while (true) {
//                try {
//                    String str = sc.nextLine();
//                    if (!str.equals("end")) {
//                        System.out.println(str);
//                    } else {
//                        pw.println("end session");
//                        pw.flush();
//                        break;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера!");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   }
}
