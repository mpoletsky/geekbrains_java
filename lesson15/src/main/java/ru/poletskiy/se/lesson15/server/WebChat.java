package ru.poletskiy.se.lesson15.server;

import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.service.ChatServiceBean;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class WebChat
{
    public static void main( String[] args ) {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");
        Endpoint.publish("http://localhost:8080/ChatService?wsdl", service);
    }
}
