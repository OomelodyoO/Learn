package cn.zhang.server;

import quickfix.*;

import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;

public class ServerApplication extends MessageCracker implements Application {

    @Override
    public void onCreate(SessionID sessionID) {
    }

    @Override
    public void onLogon(SessionID sessionID) {
    }

    @Override
    public void onLogout(SessionID sessionID) {
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("server toAdmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("server fromAdmin");
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("server toApp");
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("server fromApp");
        System.out.println("FromApp: " + message);
    }

    public static void main(String[] args) throws ConfigError, FileNotFoundException, InterruptedException, SessionNotFound {
        SessionSettings settings = new SessionSettings("acceptor.config");
        Application application = new ServerApplication();
        MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(true, true, true);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor initiator = new SocketAcceptor(application, messageStoreFactory, settings, logFactory, messageFactory);
        initiator.start();

        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Override
    protected void onMessage(Message message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        super.onMessage(message, sessionID);
    }
}