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

    AngebotTyp erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, KundeTyp kunde);

    void addProduktMengeZuAngebot(AngebotTyp angebot, ProduktTyp produkt, int menge);
}
