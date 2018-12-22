package ru.poletskiy.se.lesson15.client;

import ru.poletskiy.se.lesson15.client.command.*;
import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Contact;
import ru.poletskiy.se.lesson15.server.model.Message;
import ru.poletskiy.se.lesson15.server.model.Session;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.*;

public class ClientService {

    private static final String CMD_EXIT = "exit";

    private static final String CMD_LOGIN = "login";

    private static final String CMD_LOGOUT = "logout";

    private static final String CMD_READ = "read";

    private static final String CMD_SEND = "send";

    private static final String CMD_USERS = "users";

    private static final String CMD_CONTACTS = "contacts";

    private static final String CMD_CONTACT_CREATE = "contact-create";

    private static final String CMD_CONTACT_REMOVE = "contact-remove";

    private static final String CMD_CONTACTS_REMOVE = "contacts-remove";

    private static final String CMD_BROADCAST = "broadcast";

    private static final String LOCAL_PART = "ChatServiceBeanService";

    private static final String LOCAL_NAMESPACE = "http://service.server.lesson15.se.poletskiy.ru/";

    private static final String WSDL = "http://localhost:8080/ChatService?wsdl";

    private final Map<String, AbstractClientCommand> commands = new HashMap<>();

    private final URL url;

    private final QName qname;

    private final Service service;

    private final ChatService chatService;

    private final Scanner scanner;

    private Session session = null;

    public ClientService() throws Exception {
        url = new URL(WSDL);
        qname = new QName(LOCAL_NAMESPACE, LOCAL_PART);
        service = Service.create(url, qname);
        chatService = service.getPort(ChatService.class);
        scanner = new Scanner(System.in);

        commands.put(CMD_BROADCAST, new ClientCommandBroadcast(chatService, session, scanner));
        commands.put(CMD_CONTACT_CREATE, new ClientCommandContactCreate(chatService, session, scanner));
        commands.put(CMD_CONTACT_REMOVE, new ClientCommandContactRemove(chatService, session, scanner));
        commands.put(CMD_CONTACTS, new ClientCommandContacts(chatService, session, scanner));
        commands.put(CMD_LOGIN, new ClientCommandLogin(chatService, session, scanner));
        commands.put(CMD_LOGOUT, new ClientCommandLogout(chatService, session, scanner));
        commands.put(CMD_CONTACTS_REMOVE, new ClientCommandContactsRemove(chatService, session, scanner));
        commands.put(CMD_READ, new ClientCommandRead(chatService, session, scanner));
        commands.put(CMD_SEND, new ClientCommandSend(chatService, session, scanner));
        commands.put(CMD_USERS, new ClientCommandUsers(chatService, session, scanner));
    }

    public void run() {
        String cmd = "";
        while (!CMD_EXIT.equals(cmd)) {
            System.out.println("ENTER CMD: ");
            cmd = scanner.nextLine();
            final Command command = commands.get(cmd);
            if (command != null) command.execute();
            System.out.println();
        }
    }
}
