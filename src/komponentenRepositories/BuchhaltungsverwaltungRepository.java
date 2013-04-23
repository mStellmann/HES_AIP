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
    private IPersitenz persistenz;

    public BuchhaltungsverwaltungRepository(IPersitenz persistenz) {
        this.persistenz = persistenz;
    }

    public IZahlungseingang erstelleZahlungseingang(Date eingangsdatum, float betrag) {
        return new Zahlungseingang(eingangsdatum, betrag);
    }

    public IRechnung erstelleRechnung(Date rechnungsDatum) {
        return new Rechnung(rechnungsDatum);
    }

    // Getter
    public IZahlungseingang getZahlungseingang(int rechnungsnummer) {
        return persistenz.getObjectByID(rechnungsnummer, Zahlungseingang.class);
    }

    public IRechnung getRechnung(int rechnungsnummer) {
        return persistenz.getObjectByID(rechnungsnummer, Rechnung.class);
    }

    // Updates
    public void updateZahlungseingang(IZahlungseingang zahlungseingang) {
        persistenz.updateObject(zahlungseingang);
    }

    public void updateRechnung(IRechnung rechnung) {
        persistenz.updateObject(rechnung);
    }

    // Saves
    private void saveZahlungseingang(Zahlungseingang zahlungseingang) {
        persistenz.saveObject(zahlungseingang);
    }

    private void saveRechnung(Rechnung rechnung) {
        persistenz.saveObject(rechnung);
    }
}
