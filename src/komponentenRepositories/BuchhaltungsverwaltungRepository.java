package komponentenRepositories;

import classes.Rechnung;
import classes.Zahlungseingang;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;

/**
 * This Repository includes the CRUD-Functions for the following Classes: <br>
 * Zahlungseingang, Rechnung
 */
public class BuchhaltungsverwaltungRepository {
    // zahlungseingang, rechnung
    private IPersitenz persitenz;

    public BuchhaltungsverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IZahlungseingang erstelleZahlungseingang(Date eingangsdatum, float betrag) {
        return new Zahlungseingang(eingangsdatum, betrag);
    }

    public IRechnung erstelleRechnung(int rechnungsNummer, Date rechnungsDatum) {
        return new Rechnung(rechnungsNummer, rechnungsDatum);
    }

    // Getter
    public IZahlungseingang getZahlungseingang(int rechnungsnummer) {
        return null; // todo
    }

    public IRechnung getRechnung(int rechnungsnummer) {
        return null; // todo
    }

    // Updates
    public void updateZahlungseingang(IZahlungseingang zahlungseingang) {
        // todo
    }

    public void updateRechnung(IRechnung rechnung) {
        // todo
    }

    // Saves
    private void saveZahlungseingang(Zahlungseingang zahlungseingang) {
        // todo
    }

    private void saveRechnung(Rechnung rechnung) {
        // todo
    }
}
