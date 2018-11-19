package ru.poletskiy.se.lesson15.server.model;

import java.util.UUID;

public final class Message {
    public String id = UUID.randomUUID().toString();
    public Long timestamp = System.currentTimeMillis();
    public String source;
    public String target;
    public String text;
}
