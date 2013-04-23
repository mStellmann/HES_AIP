package komponentenInterfaces.intern;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;

import java.util.Date;

/**
 *
 */
public interface IBuchhaltungsverwaltungIntern {
    IRechnung erstelleRechnung(Date rechnungsDatum, IAuftrag auftrag);

    IZahlungseingang erstelleZahlungseingang(Date eingangsdatum, float betrag);

    void markiereRechnungAlsBezahlt(int rechnungsNummer);
}
