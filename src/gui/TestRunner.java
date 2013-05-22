package gui;

import dispatcherMonitor.Monitor;
import helper.StopWatch;

/**
 * User: Matthias
 * Date: 20.05.13
 * Time: 19:37
 */
public class TestRunner {
    public static void main(String[] args) {

        StopWatch watch = new StopWatch();

        watch.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();
        System.out.println(watch.getTime());

        watch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(watch.getTime());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();

        System.out.println(watch.getTime());
    }
}
