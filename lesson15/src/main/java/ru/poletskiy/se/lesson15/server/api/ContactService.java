package ru.poletskiy.se.lesson15.server.api;

import ru.poletskiy.se.lesson15.server.model.Contact;
import ru.poletskiy.se.lesson15.server.model.ContactBox;

public interface ContactService {

    ContactBox contacts(String login);

    Contact create(String source, String target);

    void remove(String source, String target);

    void removeAll(String login);

}
