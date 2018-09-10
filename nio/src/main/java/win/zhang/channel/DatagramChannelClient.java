package win.zhang.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf = buf.wrap("AA".getBytes());
        channel.send(buf, new InetSocketAddress("localhost", 9999));
    }
}
