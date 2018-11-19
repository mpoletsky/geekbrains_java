package ru.poletskiy.se.lesson15.server.service;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.api.MessageService;
import ru.poletskiy.se.lesson15.server.api.SessionService;
import ru.poletskiy.se.lesson15.server.api.UserService;
import ru.poletskiy.se.lesson15.server.model.Message;
import ru.poletskiy.se.lesson15.server.model.Session;
import ru.poletskiy.se.lesson15.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.poletskiy.se.lesson15.server.api.ChatService")
public final class ChatServiceBean implements ChatService {

    private final UserService userService = new UserServiceBean();

    private final MessageService messageService = new MessageServiceBean(userService);

    private final SessionService sessionService = new SessionServiceBean(userService);

    @Override
    @WebMethod
    public boolean isLoginExists(final String login) {
        return userService.isLoginExists(login);
    }

    @Override
    @WebMethod
    public boolean register(final String login, final String password) {
           return userService.register(login, password);
    }

    @Override
    @WebMethod
    public User getUser(final Session session) {
        return sessionService.getUser(session);
    }

    @Override
    @WebMethod
    public Session signIn(final String login, final String password) {
        return sessionService.signIn(login, password);
    }

    @Override
    @WebMethod
    public void signOut(final Session session) {
        sessionService.signOut(session);
    }

    @Override
    @WebMethod
    public List<Message> getMessages(final Session session) {
        final User user = sessionService.getUser(session);
        return messageService.getMessage(user.login);
    }

    @Override
    @WebMethod
    public void sendBroadcast(final Session session, final String message) {
        final User user = sessionService.getUser(session);
        messageService.sendBroadCast(user.login, message);
    }

    @Override
    @WebMethod
    public void sendMessage(final Session session, final String login, final String message) {
        final User source = sessionService.getUser(session);
        final User target = userService.getUser(login);
        messageService.sendMessage(source.login, target.login, message);
    }

    @Override
    @WebMethod
    public void clearMessages(Session session) {
        final User user = sessionService.getUser(session);
        messageService.cleanMessage(user.login);
    }

    @Override
    public List<String> getListLogin() {
        return userService.getListLogin();
    }
}
