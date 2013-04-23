package komponentenRepositories;

import classes.Angebot;
import interfaces.IAngebot;
import interfaces.IKunde;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;

/**
 * This Repository includes the CRUD-Functions for the following Classes: <br>
 * Angebot
 */
public class AngebotsverwaltungRepository {
    private IPersitenz persitenz;

    public AngebotsverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IAngebot erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        return new Angebot(angebotsNummer, gueltigAb, gueltigBis, gesamtPreis, kunde);
    }

    // Getter
    public IAngebot getAngebot(int angebotsNummer) {
        return null; // todo
    }

    // Updates
    public void updateAngebot(IAngebot angebot) {
        // todo
    }

    // Saves
    private void saveAngebot(Angebot angebot) {
        // todo
    }

}
