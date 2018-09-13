package win.zhangzhixing.runnable;

public class MyRunnable implements Runnable {
    private int num;

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().getName().equals("线程1")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":\t" + num);
                num++;
            }
        }
    }
}
