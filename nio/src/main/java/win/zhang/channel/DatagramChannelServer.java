package win.zhang.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        ByteBuffer buf = ByteBuffer.allocate(48);
        while (true) {
            channel.receive(buf);
            buf.flip();
            for (int i = 0; i < buf.limit(); i++) {
                System.out.println((char) buf.get());
            }
            buf.clear();
        }
    }
}
