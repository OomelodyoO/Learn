package cn.zhang.client;

import quickfix.*;
import quickfix.field.*;
import quickfix.fix42.NewOrderSingle;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class ClientApplication implements Application {

    private static volatile SessionID sessionID;

    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("OnCreate");
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("OnLogon");
        ClientApplication.sessionID = sessionID;
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("OnLogout");
        ClientApplication.sessionID = null;
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("client ToAdmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("client FromAdmin");
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("client ToApp: " + message);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("client FromApp");
    }

    public static void main(String[] args) throws ConfigError, FileNotFoundException, InterruptedException, SessionNotFound {
        SessionSettings settings = new SessionSettings("initiator.config");
        Application application = new ClientApplication();
        MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(true, true, true);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Initiator initiator = new SocketInitiator(application, messageStoreFactory, settings, logFactory, messageFactory);
        initiator.start();

        while (sessionID == null) {
            System.out.println("while sessionID");
            Thread.sleep(1000);
        }
        System.out.println("while sessionID===");
        final String orderId = "342";
        NewOrderSingle newOrder = new NewOrderSingle(new ClOrdID(orderId), new HandlInst('1'), new Symbol("6758.T"),
                new Side(Side.BUY), new TransactTime(LocalDateTime.now()), new OrdType(OrdType.MARKET));
        Session.sendToTarget(newOrder, sessionID);
        Thread.sleep(5000);
    }
}