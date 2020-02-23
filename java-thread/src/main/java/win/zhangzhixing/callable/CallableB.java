package win.zhangzhixing.callable;

import java.util.concurrent.Callable;

public class CallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName()+"\t"+i);
            sum += i;
        }
        return Thread.currentThread().getName()+"\t"+sum;
    }
}
