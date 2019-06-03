package win.zhangzhixing;

import win.zhangzhixing.abstractFactory.Provider;
import win.zhangzhixing.abstractFactory.SendMailFactory;
import win.zhangzhixing.adapterPattern.Adapter;
import win.zhangzhixing.decoratorPattern.Circle;
import win.zhangzhixing.decoratorPattern.RedShapeDecorator;
import win.zhangzhixing.decoratorPattern.ShapeDecorator;
import win.zhangzhixing.factoryMethod.MultipleSendFactory;
import win.zhangzhixing.factoryMethod.NormalSendFactory;
import win.zhangzhixing.factoryMethod.Sender;
import win.zhangzhixing.factoryMethod.StaticSendFactory;
import win.zhangzhixing.singleton.Singleton;

public class Application {
    public static void main(String[] args) {
        /**
         * 工厂方法模式
         */
        //  普通工厂模式
        System.out.println("======普通工厂模式======");
        NormalSendFactory normalSendFactory = new NormalSendFactory();
        Sender mail = normalSendFactory.produce("mail");
        mail.send();
        Sender sms = normalSendFactory.produce("sms");
        sms.send();
        //  多个工厂方法模式
        System.out.println("======多个工厂方法模式======");
        MultipleSendFactory multipleSendFactory = new MultipleSendFactory();
        Sender mailSenderProduce = multipleSendFactory.mailSenderProduce();
        mailSenderProduce.send();
        Sender smsSenderProduce = multipleSendFactory.smsSenderProduce();
        smsSenderProduce.send();
        //  静态工厂方法模式
        System.out.println("======静态工厂方法模式======");
        Sender staticMailSenderProduce = StaticSendFactory.mailSenderProduce();
        staticMailSenderProduce.send();
        Sender staticSmsSenderProduce = StaticSendFactory.smsSenderProduce();
        staticSmsSenderProduce.send();


        /**
         * 抽象工厂模式
         */
        System.out.println("======抽象工厂模式======");
        Provider provider = new SendMailFactory();
        win.zhangzhixing.abstractFactory.Sender produce = provider.produce();
        produce.send();

        /**
         * 单例模式
         */
        System.out.println("======单例模式======");
        Singleton singleton = Singleton.getInstance();

        /**
         * 装饰器模式
         */
        System.out.println("======装饰器模式======");
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();

        /**
         * 适配器模式
         */
        Adapter adapter = new Adapter();
        adapter.isPs2();
    }
}
