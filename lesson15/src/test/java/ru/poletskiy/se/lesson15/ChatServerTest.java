package ru.poletskiy.se.lesson15;

import org.junit.Assert;
import org.junit.Test;
import ru.poletskiy.se.lesson15.server.api.ChatService;
import ru.poletskiy.se.lesson15.server.model.Session;
import ru.poletskiy.se.lesson15.server.service.ChatServiceBean;

public class ChatServerTest {
    @Test
    public void testRegister() {
        final ChatService service = new ChatServiceBean();
        Assert.assertTrue(service.register("admin", "admin"));
        Assert.assertFalse(service.register("admin", "admin"));
    }

    @Test
    public void testIsLoginExists() {
        final ChatService service = new ChatServiceBean();
        Assert.assertFalse(service.isLoginExists("admin"));
        service.register("admin", "admin");
        Assert.assertTrue(service.isLoginExists("admin"));
    }

    @Test
    public void testSignIn() {
        final ChatService service = new ChatServiceBean();
        Assert.assertNull(service.signIn("admin", "admin"));
        service.register("admin", "admin");
        Assert.assertNotNull(service.signIn("admin", "admin"));
    }

    @Test
    public void testSignOut() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        final Session session = service.signIn("admin", "admin");
        Assert.assertNotNull(session);
        Assert.assertNotNull(service.getUser(session));
        service.signOut(session);
        Assert.assertNull(service.getUser(session));
    }

    @Test
    public void testBroadcast() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("developer", "developer");
        service.register("user", "user");

        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendBroadcast(sessionAdmin, "Test message");
        Assert.assertTrue(service.getMessages(sessionAdmin).isEmpty());

        final Session sessionDeveloper = service.signIn("developer", "developer");
        Assert.assertFalse(service.getMessages(sessionDeveloper).isEmpty());
        Assert.assertTrue(service.getMessages(sessionDeveloper).isEmpty());

        final Session sessionUser = service.signIn("user", "user");
        Assert.assertFalse(service.getMessages(sessionUser).isEmpty());
        Assert.assertTrue(service.getMessages(sessionUser).isEmpty());
    }

    @Test
    public void testSendMessage() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("developer", "developer");
        service.register("user", "user");

        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendMessage(sessionAdmin, "developer", "Test message");
        Assert.assertTrue(service.getMessages(sessionAdmin).isEmpty());

        final Session sessionDeveloper = service.signIn("developer", "developer");
        Assert.assertFalse(service.getMessages(sessionDeveloper).isEmpty());
        Assert.assertTrue(service.getMessages(sessionDeveloper).isEmpty());

        final Session sessionUser = service.signIn("user", "user");
        Assert.assertTrue(service.getMessages(sessionUser).isEmpty());
    }

}
