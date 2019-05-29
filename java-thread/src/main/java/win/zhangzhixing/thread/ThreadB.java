package win.zhangzhixing.thread;

public class ThreadB extends Thread {
    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.currentThread().sleep(100);
                System.out.println("线程" + getName() + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
