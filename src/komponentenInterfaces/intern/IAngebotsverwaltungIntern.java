package komponentenInterfaces.intern;

import interfaces.IAngebot;
import interfaces.IKunde;

import java.util.Date;

/**
 *
 */
public interface IAngebotsverwaltungIntern {
    IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde);

    IAngebot getAngebot(int angebotsNummer);
}
