package dispatcherMonitor.interfaces;

import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface IDispatcher {
    AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde);

    AngebotTyp sucheAngebot(int id);

    List<AngebotTyp> getAlleAngebote();

    void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge);

    KundeTyp erstelleKunde(String name, String adresse);

    ProduktTyp erstelleProdukt(String name, int lagerbestand);

    ProduktTyp sucheProdukt(String name);

    ProduktTyp sucheProdukt(int id);

    List<ProduktTyp> getAlleProdukte();

    KundeTyp sucheKunde(String name);

    KundeTyp sucheKunde(int id);

    List<KundeTyp> getAlleKunden();

    AuftragTyp erstelleAuftrag(Date beauftragtAm, AngebotTyp angebot);

    List<AuftragTyp> getAlleAuftraege();

    AuftragTyp sucheAuftrag(int id);
}
