package komponentenInterfaces.intern;

import interfaces.IAuftrag;
import interfaces.IRechnung;

import java.util.Date;

/**
 *
 */
public interface IBuchhaltungsverwaltungIntern {
    IRechnung erstelleRechnung(Date rechnungsDatum, IAuftrag auftrag);

    void markiereRechnungAlsBezahlt(int rechnungsNummer);
}
