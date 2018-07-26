package win.zhangzhixing.quickfix.server;

import org.springframework.stereotype.Component;
import quickfix.*;
import quickfix.fix42.Logon;
import win.zhangzhixing.quickfix.field.Password;


@Component
public class FixApplication implements Application {

    @Override
    public void onCreate(SessionID sessionId) {
        System.out.println("fix server onCreate");
    }

    @Override
    public void onLogon(SessionID sessionId) {
        System.out.println("fix server onLogon");
    }

    @Override
    public void onLogout(SessionID sessionId) {
        System.out.println("fix server onLogout");
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        System.out.println("fix server toAdmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        if (message instanceof Logon) {
            if (!message.getField(new Password()).getValue().equals("1234567890")) {
                throw new RejectLogon();
            }
        }
        System.out.println("fix server fromAdmin");
    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {
        System.out.println("fix server toApp");
    }

    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("fix server fromApp");
    }
}
