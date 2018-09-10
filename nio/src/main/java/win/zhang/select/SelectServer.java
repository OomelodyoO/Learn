package win.zhang.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int select = selector.select();
            if (select > 0) {
                Iterator keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey next = (SelectionKey) keyIterator.next();
                    keyIterator.remove();
                    if (next.isAcceptable()) {
                        System.out.println("isAcceptable");
                        SocketChannel channel = ((ServerSocketChannel) next.channel()).accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    } else if (next.isConnectable()) {
                        System.out.println("connect");
                    } else if (next.isReadable()) {
                        System.out.println("isReadable");
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        ByteBuffer readByteBuffer = ByteBuffer.allocate(100);
                        int read = socketChannel.read(readByteBuffer);
                        System.out.println(new String(readByteBuffer.array(), 0, read));
                        socketChannel.register(selector, SelectionKey.OP_WRITE);
                        socketChannel.write(readByteBuffer);
                    } else if (next.isWritable()) {
                        System.out.println("isWritable");
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                }
            }
        }
    }
}
