package win.zhangzhixing.factoryMethod;

public class MultipleSendFactory {
    public Sender mailSenderProduce() {
        return new MailSender();
    }

    public Sender smsSenderProduce() {
        return new SmsSender();
    }
}
