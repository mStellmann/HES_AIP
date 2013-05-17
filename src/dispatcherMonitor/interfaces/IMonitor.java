package dispatcherMonitor.interfaces;

/**
 *
 */
public interface IMonitor {
    boolean isVerfuegbar(int hesSystemRef);

    // TODO -> An/Aus nur simulieren.. nichts richtig abschalten.. (intern merken)
    void schalteAn(int hesSystemRef);

    void schalteAus(int hesSystemRef);
}
