package dispatcherMonitor.interfaces;

import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 */
public interface IDispatcher {
    AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde) throws RemoteException;

    AngebotTyp sucheAngebot(int id) throws RemoteException;

    List<AngebotTyp> getAlleAngebote() throws RemoteException;

    void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge) throws RemoteException;

    KundeTyp erstelleKunde(String name, String adresse) throws RemoteException;

    ProduktTyp erstelleProdukt(String name, int lagerbestand) throws RemoteException;

    ProduktTyp sucheProdukt(String name) throws RemoteException;

    ProduktTyp sucheProdukt(int id);

    List<ProduktTyp> getAlleProdukte();

    KundeTyp sucheKunde(String name);

    KundeTyp sucheKunde(int id);

    List<KundeTyp> getAlleKunden();

    AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot);

    List<AuftragTyp> getAlleAuftraege();

    AuftragTyp sucheAuftrag(int id);
}
