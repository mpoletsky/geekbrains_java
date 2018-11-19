package ru.poletskiy.se.lesson15.server.api;

import ru.poletskiy.se.lesson15.server.model.Session;
import ru.poletskiy.se.lesson15.server.model.User;

public interface SessionService {

    Session signIn(String login, String password);

    User getUser(Session session);

    void signOut(Session session);

}
