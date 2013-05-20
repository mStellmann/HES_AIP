package dispatcherMonitor;

import dispatcherMonitor.interfaces.IMonitor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO UDP-Anbindung bauen
 */
public class Monitor implements IMonitor {

    private final int UPDATEINTERVAL = 500;
    private final int HEARTBEAT_PORT = 50001;
    private final int MONITOR_PORT = 50000;

    private int nextSystem = 0;
    private Map<String, InetAddress> hesSystemsMap;  // Name (Nummer) -> Adresse
    private boolean[] isAliveAry;
    private DatagramSocket udpSocket;

    public Monitor() {
        try {
            udpSocket = new DatagramSocket(MONITOR_PORT);
        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        hesSystemsMap = new HashMap<Integer, InetAddress>();
        isAliveAry = new boolean[10];

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    receiveMessages();
                }
            }
        }.start();
    }

    private void receiveMessages() {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, 1024);
        try {
            udpSocket.receive(receivePacket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String rcvText = new String(receivePacket.getData(), 0, receivePacket.getLength());
        String rcvName = rcvText.split("_")[1];
        String rcvCommand = rcvText.split("_")[0];
        switch (rcvCommand) {
            case "CONNECT":
                hesSystemsMap.put(rcvName, receivePacket.getAddress());
                break;
            case "ALIVE":

                break;
            default:
                System.out.println("Monitor-Error - received Message: " + rcvText);
                break;
        }
    }

    @Override
    public boolean isVerfuegbar(int hesSystemRef) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void schalteAn(int hesSystemRef) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void schalteAus(int hesSystemRef) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Integer> getSysteme() {
        return hesSystemsMap.keySet();
    }
}
