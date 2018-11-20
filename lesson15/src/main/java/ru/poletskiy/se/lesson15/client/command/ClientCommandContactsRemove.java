package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.Scanner;

public class ClientCommandContactsRemove extends AbstractClientCommand {

    public ClientCommandContactsRemove(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        chatService.removeContacts(session);
    }
}
