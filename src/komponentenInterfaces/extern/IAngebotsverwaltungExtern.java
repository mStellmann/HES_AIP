package komponentenInterfaces.extern;

import typClasses.AngebotTyp;
import typClasses.AuftragTyp;
import typClasses.KundeTyp;
import typClasses.ProduktTyp;

import java.util.Date;

/**
 *
 */
public interface IAngebotsverwaltungExtern {

    AngebotTyp erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, KundeTyp kunde);

    void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge);
}
