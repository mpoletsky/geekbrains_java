package ru.poletskiy.se.lesson26.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoChatClient {
    private Scanner in = null;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket sock;
    private PrintWriter out;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EchoChatClient client = new EchoChatClient();
        client.newMethod();
    }
    public void newMethod () {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (in.hasNext()) {
                                String w = in.nextLine();
                                if (w.equalsIgnoreCase("end session")) break;
                                System.out.println(w);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
            while (true) {
                Scanner myscan = new Scanner(System.in);
                String str = myscan.nextLine();
                if ("end".equals(str)) break;
                out.println(str);
                out.flush();
            }
            try {
                out.println("end");
                out.flush();
                sock.close();
                out.close();
                in.close();
            } catch (IOException exc) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
