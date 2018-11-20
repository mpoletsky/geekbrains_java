package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.Scanner;

public class ClientCommandContactRemove extends AbstractClientCommand {

    public ClientCommandContactRemove(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        System.out.println("ENTER LOGIN: ");
        final String login = scanner.nextLine();
        chatService.removeContact(session, login);
    }
}
