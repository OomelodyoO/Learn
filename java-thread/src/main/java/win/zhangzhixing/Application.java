package win.zhangzhixing;

import win.zhangzhixing.thread.ThreadA;
import win.zhangzhixing.thread.ThreadB;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA("A");
        ThreadB threadB = new ThreadB("B");
//        testNormal(threadA, threadB);
//        testWait(threadA, threadB);
//        testJoin(threadA, threadB);
        testInterrupt(threadA, threadB);
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程:" + i);
        }
    }

    public static void testNormal(ThreadA threadA, ThreadB threadB) {
        System.out.println("======普通线程启动======");
        threadA.start();
        threadB.start();
    }

    public static void testWait(ThreadA threadA, ThreadB threadB) throws InterruptedException {
        System.out.println("======wait 测试======");
        threadA.start();
        synchronized (threadA) {
            threadA.wait();
        }
        threadB.start();
        synchronized (threadA) {
            threadA.notify();
        }
    }

    public static void testJoin(ThreadA threadA, ThreadB threadB) throws InterruptedException {
        System.out.println("======join 测试======");
        threadA.start();
        threadA.join();
        threadB.start();
    }

    public static void testInterrupt(ThreadA threadA, ThreadB threadB) throws InterruptedException {
        System.out.println("======interrupt 测试======");
        threadA.start();
        threadA.interrupt();
        threadB.start();
    }
}
