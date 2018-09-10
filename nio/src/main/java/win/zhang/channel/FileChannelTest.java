package win.zhang.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        FileChannel inputFileChannel = new FileInputStream("file.text absolute path").getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(100);
        inputFileChannel.read(readBuffer);
        readBuffer.flip();
        for (int i = 0; i < readBuffer.limit(); i++) {
            System.out.println((char) readBuffer.get());
        }

        FileChannel outputFileChannel = new FileOutputStream("file.text absolute path", true).getChannel();
        ByteBuffer writeBuffer = ByteBuffer.wrap("TOM".getBytes());
        outputFileChannel.write(writeBuffer);

        inputFileChannel.close();
        outputFileChannel.close();
    }
}
