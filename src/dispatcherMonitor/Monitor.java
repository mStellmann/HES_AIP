package dispatcherMonitor;

import dispatcherMonitor.interfaces.IMonitor;
import helper.StopWatch;
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
    private Map<String, StopWatch> upTimeMap;
    private Map<String, StopWatch> downTimeMap;
    private Map<String, Integer> opCountMap;

    public Monitor() {
        upTimeMap = new HashMap<String, StopWatch>();
        downTimeMap = new HashMap<String, StopWatch>();
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
                initMaps(rcvName);
                System.out.println("[Monitor-Info] " + getTimeStamp() + " System connected: " + rcvName);
                break;
            case "ALIVE":
                hesSystemsMap.put(rcvName, Triplet.with(receivePacket.getAddress(), true, System.currentTimeMillis()));
                initMaps(rcvName);
                System.out.println("[Monitor-Info] " + getTimeStamp() + " System alive: " + rcvName);
                break;
            default:
                System.out.println("[Monitor-Error] " + getTimeStamp() + " received Message: " + rcvText);
                break;
        }
    }

    private void initMaps(String hesRevName) {
        if (!systemStatusForceOff.containsKey(hesRevName))
            schalteAn(hesRevName);
        if (!upTimeMap.containsKey(hesRevName))
            upTimeMap.put(hesRevName, new StopWatch());
        if (!downTimeMap.containsKey(hesRevName))
            downTimeMap.put(hesRevName, new StopWatch());
        if (!upTimeMap.get(hesRevName).isRunning())
            upTimeMap.get(hesRevName).start();
        if (downTimeMap.get(hesRevName).isRunning())
            downTimeMap.get(hesRevName).stop();
    }


    private void pruefeSystemAmLeben() {
        while (true) {
            try {
                for (String elem : hesSystemsMap.keySet()) {
                    if (System.currentTimeMillis() - hesSystemsMap.get(elem).getValue2() > 1600) {
                        hesSystemsMap.put(elem, Triplet.with(hesSystemsMap.get(elem).getValue0(), false, System.currentTimeMillis()));
                        System.out.println("[Monitor-Info] " + getTimeStamp() + " System dead: " + elem);
                        if (upTimeMap.get(elem).isRunning())
                            upTimeMap.get(elem).stop();
                        if (!downTimeMap.get(elem).isRunning())
                            downTimeMap.get(elem).start();
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
    public long getUptime(String hesSystemRef) {
        if (!upTimeMap.containsKey(hesSystemRef))
            return 0;
        else {
            return upTimeMap.get(hesSystemRef).getTime();
        }
    }

    @Override
    public long getDowntime(String hesSystemRef) {
        if (!downTimeMap.containsKey(hesSystemRef))
            return 0;
        else {
            return downTimeMap.get(hesSystemRef).getTime();
        }
    }

    @Override
    public int getOpCount(String hesSystemRef) {
        if (!opCountMap.containsKey(hesSystemRef))
            return 0;
        else
            return opCountMap.get(hesSystemRef);
    }

    @Override
    public void countOneOp(String hesSystemRef) {
        if (!opCountMap.containsKey(hesSystemRef))
            opCountMap.put(hesSystemRef, 1);
        else
            opCountMap.put(hesSystemRef, opCountMap.get(hesSystemRef) + 1);
    }
}
