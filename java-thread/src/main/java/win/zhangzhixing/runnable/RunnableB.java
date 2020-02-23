package win.zhangzhixing.runnable;

public class RunnableB implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }
}
