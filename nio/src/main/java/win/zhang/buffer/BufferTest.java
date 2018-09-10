package win.zhang.buffer;

import java.nio.IntBuffer;

public class BufferTest {
    public static void main(String[] args) {
        IntBuffer buff = IntBuffer.allocate(10);
        buff.get();
        buff.put(1);
        buff.get();
        buff.put(2);
        buff.get();
        buff.put(3);
        buff.mark();
        buff.get();
        buff.put(4);
        buff.get();
        buff.put(5);
        System.out.println(" ========== init ========== ");
        System.out.println("capacity:\t" + buff.capacity());
        System.out.println("limit:\t" + buff.limit());
        System.out.println("position:\t" + buff.position());
        System.out.println();
        buff.reset();
        System.out.println(" ========== mark reset ========== ");
        System.out.println("capacity:\t" + buff.capacity());
        System.out.println("limit:\t" + buff.limit());
        System.out.println("position:\t" + buff.position());
        System.out.println();
        buff.flip();
        System.out.println(" ========== flip ========== ");
        System.out.println("capacity:\t" + buff.capacity());
        System.out.println("limit:\t" + buff.limit());
        System.out.println("position:\t" + buff.position());
        for (int i = 0; i < buff.limit(); i++) {
            System.out.print(buff.get() + "\t");
        }
        System.out.println();
        System.out.println();
        buff.clear();
        System.out.println(" ========== clear ========== ");
        System.out.println("capacity:\t" + buff.capacity());
        System.out.println("limit:\t" + buff.limit());
        System.out.println("position:\t" + buff.position());
        for (int i = 0; i < buff.limit(); i++) {
            System.out.print(buff.get() + "\t");
        }
        System.out.println();
        System.out.println();

        //重新数据初始化
        System.out.println(" ========== duplicate ========== ");
        buff.clear();
        IntBuffer copyIntBuffer = buff.duplicate();
        buff.get();
        buff.put(2);
        System.out.println(" ========== buff duplicate ========== ");
        System.out.println("capacity:\t" + buff.capacity());
        System.out.println("limit:\t" + buff.limit());
        System.out.println("position:\t" + buff.position());
        System.out.println(buff);
        System.out.println(" ========== copyIntBuffer duplicate ========== ");
        System.out.println("capacity:\t" + copyIntBuffer.capacity());
        System.out.println("limit:\t" + copyIntBuffer.limit());
        System.out.println("position:\t" + copyIntBuffer.position());
        for (int i = 0; i < buff.limit(); i++) {
            System.out.print(copyIntBuffer.get() + "\t");
        }
        System.out.println();
    }
}
