package komponentenRepositories;

import classes.Auftrag;
import classes.Lieferung;
import classes.Transportauftrag;
import interfaces.IAngebot;
import interfaces.IAuftrag;
import interfaces.ILieferung;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.IPersitenz;
import typClasses.AuftragTyp;

import java.util.Date;
import java.util.List;

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
        Auftrag auftrag = new Auftrag(beauftragtAm, angebot);
        saveAuftrag(auftrag);
        return auftrag;
    }

    public ITransportauftrag erstelleTransportauftrag(Date ausgangsdatum, String transportdienstleister) {
        Transportauftrag transportauftrag = new Transportauftrag(ausgangsdatum, transportdienstleister);
        saveTransportauftrag(transportauftrag);
        return transportauftrag;
    }

    public ILieferung erstelleLieferung() {
        Lieferung lieferung = new Lieferung();
        saveLieferung(lieferung);
        return lieferung;
    }

    // Getter
    public IAuftrag getAuftrag(int auftragsNummer) {
        return persitenz.getObjectByID(auftragsNummer, Auftrag.class);
    }

    public ITransportauftrag getTransportauftrag(int transportauftragsNummer) {
        return persitenz.getObjectByID(transportauftragsNummer, Transportauftrag.class);
    }

    public ILieferung getLieferung(int lieferungsNummer) {
        return persitenz.getObjectByID(lieferungsNummer, Lieferung.class);
    }

    // Updates
    public void updateAuftrag(IAuftrag auftrag) {
        persitenz.updateObject(auftrag);
    }

    public void updateTransportauftrag(ITransportauftrag transportauftrag) {
        persitenz.updateObject(transportauftrag);
    }

    public void updateLieferung(ILieferung lieferung) {
        persitenz.updateObject(lieferung);
    }

    // Saves
    private void saveAuftrag(Auftrag auftrag) {
        persitenz.saveObject(auftrag);
    }

    private void saveTransportauftrag(Transportauftrag transportauftrag) {
        persitenz.saveObject(transportauftrag);
    }

    private void saveLieferung(Lieferung lieferung) {
        persitenz.saveObject(lieferung);
    }

    public List<? extends IAuftrag> getAlleAuftraege() {
        return persitenz.getAllObjects(Auftrag.class);
    }

    public IAuftrag sucheAuftrag(int id) {
        return persitenz.getObjectByID(id, Auftrag.class);
    }
}
