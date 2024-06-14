package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private SocketChannel channel;
    private BufferedReader reader;
    private PrintWriter writer;
    private DataTransfer dataTransfer;
    public ClientHandler(SocketChannel channel,DataTransfer dataTransfer){
        this.dataTransfer = dataTransfer;
        this.channel = channel;
        reader =new BufferedReader(Channels.newReader(channel, StandardCharsets.UTF_8));
        writer = new PrintWriter(Channels.newWriter(channel,StandardCharsets.UTF_8));
        dataTransfer.setAction(e -> write());
    }

    public void write(){
        writer.println(dataTransfer.getUsername()+": "+dataTransfer.getMessage());
        writer.println(dataTransfer.boxesToString());
        writer.flush();
    }

    public void read(){
        String msg="";
        try{
            while ((msg = reader.readLine()) != null){
                if(msg.startsWith("1xz")){
                 String []list = msg.split(" ");
                 int []checkBoxes = new int[list.length-1];
                 for(int i = 1; i < list.length; i++){

                     checkBoxes[i-1] = Integer.parseInt(list[i]);
                    }
                 dataTransfer.setArray(checkBoxes);

                } else {
                    dataTransfer.sendToGui(msg);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        read();
    }
}
