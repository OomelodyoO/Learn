package win.zhangzhixing.thread;

public class ThreadA extends Thread {
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (!this.isInterrupted()) {
                    sleep(50);
                    System.out.println("线程" + getName() + ":" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
