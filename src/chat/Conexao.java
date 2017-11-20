package chat;

import java.util.Observable;

public class Conexao extends Observable {

    private String ip;
    private int porta;
    private String mensagem;

    public Conexao(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
        new Thread(new Recebe()).start();
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getIp() {
        return ip;
    }

    public int getPorta() {
        return porta;
    }

    public void envia(String texto) {
        new Thread(new Envia(texto)).start();
    }

    public void notifica(String mensagem) {
        this.mensagem = mensagem;
        setChanged();
        notifyObservers();
    }
}