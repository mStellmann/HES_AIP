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

    public IAngebot erstelleAngebot(Date gueltigAb, Date gueltigBis, float gesamtPreis, IKunde kunde) {
        Angebot angebot = new Angebot(gueltigAb, gueltigBis, gesamtPreis, kunde);
        saveAngebot(angebot);
        return angebot;
    }

    // Getter
    public IAngebot getAngebot(int angebotsNummer) {
        return persitenz.getObjectByID(angebotsNummer, Angebot.class);
    }

    // Updates
    public void updateAngebot(IAngebot angebot) {
        persitenz.updateObject(angebot);
    }

    // Saves
    private void saveAngebot(Angebot angebot) {
        persitenz.saveObject(angebot);
    }

}
