package win.zhangzhixing;

import win.zhangzhixing.runnable.MyRunnable;

public class javaApplication {
    public static void main(String[] args) {
        int num = 0;
        MyRunnable r = new MyRunnable(num);

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }
}