package win.zhangzhixing;

import win.zhangzhixing.callable.CallableA;
import win.zhangzhixing.callable.CallableB;
import win.zhangzhixing.runnable.RunnableA;
import win.zhangzhixing.runnable.RunnableB;
import win.zhangzhixing.thread.ThreadA;
import win.zhangzhixing.thread.ThreadB;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Application {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadA threadA = new ThreadA("A");
        ThreadB threadB = new ThreadB("B");
        testNormal(threadA, threadB);
//        testWait(threadA, threadB);
//        testJoin(threadA, threadB);
//        testInterrupt(threadA, threadB);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main:" + i);
//        }


//        testRunnable(new RunnableA(), new RunnableB());

//        testCallable(new CallableA(), new CallableB());
    }

    public static void testNormal(ThreadA threadA, ThreadB threadB) {
        System.out.println("======testNormal======");
        threadA.start();
        threadB.start();
    }

    public static void testWait(ThreadA threadA, ThreadB threadB) throws InterruptedException {
        System.out.println("======testWait======");
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
        System.out.println("======testJoin======");
        threadA.start();
        threadA.join();
        threadB.start();
    }

    public static void testInterrupt(ThreadA threadA, ThreadB threadB) throws InterruptedException {
        System.out.println("======testInterrupt======");
        threadA.start();
        threadA.interrupt();
        threadB.start();
    }

    public static void testRunnable(RunnableA runnableA, RunnableB runnableB) {
        Thread threadA = new Thread(runnableA, "runnnableA");
        Thread threadB = new Thread(runnableB, "runnnableB");
        threadA.start();
        threadB.start();
    }

    public static void testCallable(CallableA callableA, CallableB callableB) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTaskA = new FutureTask<>(callableA);
        new Thread(futureTaskA, "callableA").start();
        System.out.println(futureTaskA.get());

        FutureTask<String> futureTaskB = new FutureTask<>(callableB);
        new Thread(futureTaskB, "callableB").start();
        System.out.println(futureTaskB.get());
    }
}
