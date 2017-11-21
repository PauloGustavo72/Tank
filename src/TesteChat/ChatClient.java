package TesteChat;

import java.net.DatagramSocket;

public class ChatClient {
    
    public void seVira() throws Exception {
        String host = "127.0.0.1";
        DatagramSocket socket = new DatagramSocket();
        MessageReceiver r = new MessageReceiver(socket);
        MessageSender s = new MessageSender(socket, host);
        Thread rt = new Thread(r);
        Thread st = new Thread(s);
        rt.start(); st.start();
    }
}