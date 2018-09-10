package win.zhang.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioChannelServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        ByteBuffer buf = ByteBuffer.allocate(48);
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();
            while (true) {
                channel.read(buf);
                buf.flip();
                for (int i = 0; i < buf.limit(); i++) {
                    System.out.println((char) buf.get());
                }
                buf.clear();
            }
        }
    }
}
