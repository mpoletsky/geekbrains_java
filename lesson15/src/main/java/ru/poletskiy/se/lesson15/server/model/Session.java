package ru.poletskiy.se.lesson15.server.model;

import java.util.Objects;
import java.util.UUID;

public class Session {
    public Long timestamp = System.currentTimeMillis();
    public String id = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        final boolean checkTimestamp = Objects.equals(id, session.id);
        final boolean checkSessionId = Objects.equals(id, session.id);
        return checkTimestamp && checkSessionId;
    }

    @Override
    public int hashCode() { return Objects.hash(timestamp, id); }
}
