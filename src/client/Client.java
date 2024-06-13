package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    SocketChannel channel;
    ClientHandler handler;

    public Client(DataTransfer dataTransfer) {
        try {
            channel = SocketChannel.open(new InetSocketAddress("Localhost",5000));
            handler = new ClientHandler(channel, dataTransfer);
            Thread thread = new Thread(handler);
            thread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
