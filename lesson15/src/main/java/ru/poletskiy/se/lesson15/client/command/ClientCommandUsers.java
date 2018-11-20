package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.Scanner;

public class ClientCommandUsers extends AbstractClientCommand {

    public ClientCommandUsers(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println(chatService.getListLogin());
    }
}
