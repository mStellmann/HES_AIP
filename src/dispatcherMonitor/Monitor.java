package dispatcherMonitor;

import dispatcherMonitor.interfaces.IMonitor;
import org.javatuples.Triplet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;

/**
 *
 */
public class Monitor implements IMonitor {

    private final int UPDATEINTERVAL = 500;
    private final int MONITOR_PORT = 50000;

    private int nextSystem = 0;
    private Map<String, Triplet<InetAddress, Boolean, Long>> hesSystemsMap;  // IP, isAlive, lastTimeStamp
    private Map<String, Boolean> systemStatusForceOff;
    private DatagramSocket udpSocket;
    private Map<String, Integer> upTimeMap;
    private Map<String, Integer> downTimeMap;
    private Map<String, Integer> opCountMap;

    public Monitor() {
        upTimeMap = new HashMap<String, Integer>();
        downTimeMap = new HashMap<String, Integer>();
        opCountMap = new HashMap<String, Integer>();

        try {
            udpSocket = new DatagramSocket(MONITOR_PORT);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        hesSystemsMap = new HashMap<String, Triplet<InetAddress, Boolean, Long>>();
        systemStatusForceOff = new HashMap<String, Boolean>();

        // Dieser Thread empfängt alle Nachrichten..
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    receiveMessages();
                }
            }
        }.start();

        // Dieser Thread prueft ob das System noch am leben ist
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    pruefeSystemAmLeben();
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
        String rcvName = rcvText.split("_")[0];
        String rcvCommand = rcvText.split("_")[1];
        switch (rcvCommand) {
            case "CONNECT":
                hesSystemsMap.put(rcvName, Triplet.with(receivePacket.getAddress(), true, System.currentTimeMillis()));
                if (!systemStatusForceOff.containsKey(rcvName))
                    schalteAn(rcvName);

                System.out.println("[Monitor-Info] " + getTimeStamp() + " System connected: " + rcvName);
                break;
            case "ALIVE":
                hesSystemsMap.put(rcvName, Triplet.with(receivePacket.getAddress(), true, System.currentTimeMillis()));
                if (!systemStatusForceOff.containsKey(rcvName))
                    schalteAn(rcvName);
                System.out.println("[Monitor-Info] " + getTimeStamp() + " System alive: " + rcvName);
                break;
            default:
                System.out.println("[Monitor-Error] " + getTimeStamp() + " received Message: " + rcvText);
                break;
        }
    }

    private void pruefeSystemAmLeben() {
        while (true) {
            try {
                for (String elem : hesSystemsMap.keySet()) {
                    if (System.currentTimeMillis() - hesSystemsMap.get(elem).getValue2() > 1600) {
                        hesSystemsMap.put(elem, Triplet.with(hesSystemsMap.get(elem).getValue0(), false, System.currentTimeMillis()));
                        System.out.println("[Monitor-Info] " + getTimeStamp() + " System dead: " + elem);
                    }
                }
                Thread.sleep(UPDATEINTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTimeStamp() {
        String datum = new Date().toString().split(" ")[3];
        return datum = "(" + datum + ") ";
    }

    @Override
    public boolean isVerfuegbar(String hesSystemRef) {
        if (!systemStatusForceOff.get(hesSystemRef))
            return hesSystemsMap.get(hesSystemRef).getValue1();
        else
            return false;
    }

    @Override
    public void schalteAn(String hesSystemRef) {
        System.out.println("[Monitor-Info] " + getTimeStamp() + " System switched On: " + hesSystemRef);
        systemStatusForceOff.put(hesSystemRef, false);
    }

    @Override
    public void schalteAus(String hesSystemRef) {
        System.out.println("[Monitor-Info] " + getTimeStamp() + " System switched Off: " + hesSystemRef);
        systemStatusForceOff.put(hesSystemRef, true);
    }

    @Override
    public Set<String> getSysteme() {
        return hesSystemsMap.keySet();
    }

    @Override
    public int getUptime(String hesSystemRef) {
        return 0;  // TODO
    }

    @Override
    public int getDowntime(String hesSystemRef) {
        return 0;  // TODO
    }

    @Override
    public int getOpCount(String hesSystemRef) {
        return 0;  // TODO
    }
}
