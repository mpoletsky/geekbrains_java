package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Message;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.List;
import java.util.Scanner;

public class ClientCommandRead extends AbstractClientCommand {

    public ClientCommandRead(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        final List<Message> messages = chatService.getMessages(session);
        for (final Message message : messages) {
            System.out.println("** INCOME MESSAGE **");
            System.out.println("FROM: " + message.source);
            System.out.println("TEXT: " + message.text);
        }
    }
}
