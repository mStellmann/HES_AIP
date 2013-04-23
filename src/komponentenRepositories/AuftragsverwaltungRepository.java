package komponentenRepositories;

import classes.Auftrag;
import classes.Lieferung;
import classes.Transportauftrag;
import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;

/**
 * This Repository includes the CRUD-Functions for the following Classes: <br>
 * Auftrag, Transportauftrag, Lieferung
 */
public class AuftragsverwaltungRepository {

    private IPersitenz persitenz;

    public AuftragsverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IAuftrag erstelleAuftrag(Date beauftragtAm, IAngebot angebot) {
        return new Auftrag(beauftragtAm, angebot);
    }

    public ITransportauftrag erstelleTransportauftrag(Date ausgangsdatum, String transportdienstleister) {
        return new Transportauftrag(ausgangsdatum, transportdienstleister);
    }

    public ILieferung erstelleLieferung() {
        return new Lieferung();
    }

    // Getter
    public IAuftrag getAuftrag(int auftragsNummer) {
        return null; // todo
    }

    public ITransportauftrag getTransportauftrag(int transportauftragsNummer) {
        return null; // todo
    }

    public ILieferung getLieferung(int lieferungsNummer) {
        return null; // todo
    }

    // Updates
    public void updateAuftrag(IAuftrag auftrag) {
        // todo
    }

    public void updateTransportauftrag(ITransportauftrag transportauftrag) {
        // todo
    }

    public void updateLieferung(ILieferung lieferung) {
        // todo
    }

    // Saves
    private void saveAuftrag(Auftrag auftrag) {
        // todo
    }

    private void saveTransportauftrag(Transportauftrag transportauftrag) {
        // todo
    }

    private void saveLieferung(Lieferung lieferung) {
        // todo
    }


}
