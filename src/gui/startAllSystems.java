package gui;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 *
 */
public class startAllSystems {
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        String[] sys1 = {"SYS1", "50001"};
        String[] sys2 = {"SYS2", "50002"};
        SystemRunner.main(sys1);
        SystemRunner.main(sys2);
    }
}
