package win.zhang.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioChannelClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));
        while (true) {
            Scanner input = new Scanner(System.in);
            socketChannel.write(ByteBuffer.wrap(input.nextLine().getBytes()));
        }
    }
}
