package gui;

import dispatcherMonitor.Monitor;

/**
 * User: Matthias
 * Date: 20.05.13
 * Time: 19:37
 */
public class TestRunner {
    public static void main(String[] args) {

        System.out.println("system1_ALIVE".split("_")[0]);

        Monitor monitor = new Monitor();
        Heartbeat hb1 = new Heartbeat("system1", 50001);
        Heartbeat hb2 = new Heartbeat("system2", 50002);

        hb1.start();
        hb2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hb1.interrupt();
    }
}
