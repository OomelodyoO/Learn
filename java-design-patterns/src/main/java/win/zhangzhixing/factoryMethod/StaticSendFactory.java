package win.zhangzhixing.factoryMethod;

public class StaticSendFactory {
    public static Sender mailSenderProduce(){
        return new MailSender();
    }

    public static Sender smsSenderProduce(){
        return new SmsSender();
    }
}
