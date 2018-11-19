package ru.poletskiy.se.lesson15.server.api;

import ru.poletskiy.se.lesson15.server.model.User;

import java.util.List;

public interface UserService {

    boolean register(String login, String password);

    List<String> getListLogin();

    User getUser(String login);

    void createUser(String login, String password);

    boolean isLoginExists(String login);

    void removeUser(String login);

    int getCountUser();

    void removeAll();

}
