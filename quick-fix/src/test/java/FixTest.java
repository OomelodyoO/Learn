import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import quickfix.*;
import quickfix.field.*;
import quickfix.fix42.Logon;
import quickfix.fix42.NewOrderSingle;
import win.zhangzhixing.quickfix.field.Password;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
public class FixTest implements quickfix.Application {

    private static volatile SessionID sessionID;

    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("OnCreate");
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("OnLogon");
        FixTest.sessionID = sessionID;
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("OnLogout");
        FixTest.sessionID = null;
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        if (message instanceof Logon) {
            message.setField(new Password("1234567890"));
        }
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

    @Test
    public void check() {
        FixTest.checkSum("8=FIX.4.2\u00019=68\u000135=A\u000134=17\u000149=client\u000152=20180719-07:51:26\u000156=server\u000198=0\u0001108=30\u0001");
    }


    public static String checkSum(String headerAndBody) {
        byte[] headerAndBodyBytes = headerAndBody.getBytes();
        int sum = 0;
        for (byte b : headerAndBodyBytes) {
            sum += b;
        }
        String rt = String.valueOf((sum) % 256);
        /*
         * 在模256之后需要转换成固定长度为3字符串
         */
        if (rt.length() == 1) {
            rt = "00" + rt;
        } else if (rt.length() == 2) {
            rt = "0" + rt;
        } else {
        }
        System.out.println(rt);
        return rt;
    }

    @Test
    public void test() throws ConfigError, InterruptedException, SessionNotFound {
        Date start = new Date();
        SessionSettings settings = new SessionSettings("initiator.config");
        Application application = new FixTest();
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
        for (Integer i = 0; i < 1; i++) {
            NewOrderSingle newOrder = new NewOrderSingle(new ClOrdID(i.toString()), new HandlInst('1'), new Symbol("6758.T"),
                    new Side(Side.BUY), new TransactTime(LocalDateTime.now()), new OrdType(OrdType.MARKET));
            Session.sendToTarget(newOrder, sessionID);
        }
        Date end = new Date();
        System.out.println(start);
        System.out.println(end);
        Thread.sleep(5000);
    }

}
