package ru.poletskiy.se.lesson15.client.command;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;

import java.util.Scanner;

public abstract class AbstractClientCommand implements Command {

    protected ChatService chatService;

    protected Session session;

    protected Scanner scanner;

    public AbstractClientCommand(ChatService chatService, Session session, Scanner scanner) {
        this.chatService = chatService;
        this.session = session;
        this.scanner = scanner;
    }
}
