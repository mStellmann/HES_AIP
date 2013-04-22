package komponentenRepositories;

import classes.Angebot;
import interfaces.IAngebot;
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

    public IAngebot erstelleAngebot(int angebotsNummer, Date gueltigAb, Date gueltigBis) {
        return new Angebot(angebotsNummer, gueltigAb, gueltigBis);
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
