package dispatcherMonitor.interfaces;

import java.util.Set;

/**
 *
 */
public interface IMonitor {
    boolean isVerfuegbar(int hesSystemRef);

    // TODO -> An/Aus nur simulieren.. nichts richtig abschalten.. (intern merken)
    void schalteAn(int hesSystemRef);

    void schalteAus(int hesSystemRef);

    Set<Integer> getSysteme();
}
