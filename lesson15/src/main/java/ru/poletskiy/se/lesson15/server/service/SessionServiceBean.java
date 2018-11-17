package ru.poletskiy.se.lesson15.server.service;

import ru.poletskiy.se.lesson15.server.api.SessionService;
import ru.poletskiy.se.lesson15.server.api.UserService;
import ru.poletskiy.se.lesson15.server.model.Session;
import ru.poletskiy.se.lesson15.server.model.User;

import java.util.HashMap;
import java.util.Map;

public final class SessionServiceBean implements SessionService {

    private final UserService userService;

    private final Map<Session, User> sessions = new HashMap<>();

    public SessionServiceBean(final UserService userService) { this.userService = userService; }

    @Override
    public Session signIn(String login, String password) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        final User user = userService.getUser(login);
        if (user == null) return null;
        if (!password.equals(user.password)) return null;
        final Session session = new Session();
        sessions.put(session, user);
        return session;
    }

    @Override
    public User getUser(Session session) {
        if (session == null) return null;
        return sessions.get(session);
    }

    @Override
    public void signOut(Session session) {
        if (session == null) return;
        sessions.remove(session);
    }
}
