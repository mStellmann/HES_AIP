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

    void markiereRechnungAlsBezahlt(int rechnungsNummer);

    void getZahlungseingaengeVonAdapter();

    IZahlungseingang erstelleZahlungseingang(Date eingangsdatum, float betrag);

    IRechnung getRechnung(int rechnungsNummer);

    IZahlungseingang getZahlungseingang(int rechnungsNummer);
}
