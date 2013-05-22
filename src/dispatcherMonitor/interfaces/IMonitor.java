package dispatcherMonitor.interfaces;

import java.util.Set;

/**
 *
 */
public interface IMonitor {
    boolean isVerfuegbar(String hesSystemRef);

    void schalteAn(String hesSystemRef);

    void schalteAus(String hesSystemRef);

    Set<String> getSysteme();

    long getUptime(String hesSystemRef);

    long getDowntime(String hesSystemRef);

    int getOpCount(String hesSystemRef);

    void countOneOp(String hesSystemRef);
}
