package dispatcherMonitor.interfaces;

import java.util.Set;

/**
 *
 */
public interface IMonitor {
    boolean isVerfuegbar(String hesSystemRef);

    // TODO -> An/Aus nur simulieren.. nichts richtig abschalten.. (intern merken)
    void schalteAn(String hesSystemRef);

    void schalteAus(String hesSystemRef);

    Set<String> getSysteme();
}
