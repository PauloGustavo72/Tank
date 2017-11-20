package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Envia implements Runnable {

    String texto;

    public Envia(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {

        byte[] dados = texto.getBytes();

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, addr, 12345);
            clientSocket.send(pacote);
            clientSocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

