package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.Scanner;

public class ClientCommandBroadcast extends AbstractClientCommand {

    public ClientCommandBroadcast(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("ENTER MESSAGE: ");
        final String message = scanner.nextLine();
        chatService.sendBroadcast(session, message);
    }
}

