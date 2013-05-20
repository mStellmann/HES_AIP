package gui;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * User: Matthias
 * Date: 20.05.13
 * Time: 17:10
 */
public class Heartbeat extends Thread {

    private final int UPDATEINTERVAL = 500;
    private final int MONITOR_PORT = 50000;
    private final String MONITOR_ADRESS = "localhost";

    private DatagramSocket udpSocket;
    private String name;

    public Heartbeat(String name, int port) {
        this.name = name;
        try {
            udpSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        sendMessage("CONNECT");
        while (true) {
            try {
                sendMessage("ALIVE");
                Thread.sleep(UPDATEINTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void sendMessage(String textToSend) {
        byte[] bAry = (name + "_" + textToSend).getBytes();
        try {
            udpSocket.send(new DatagramPacket(bAry, bAry.length, InetAddress.getByName(MONITOR_ADRESS), MONITOR_PORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
