package komponentenRepositories;

import classes.Kunde;
import interfaces.IKunde;
import komponentenInterfaces.intern.IPersitenz;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class KundenverwaltungRepository {
    private IPersitenz persitenz;

    public KundenverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IKunde erstelleKunde(String name, String adresse) {
        Kunde kunde = new Kunde(name, adresse);
        saveKunde(kunde);
        return kunde;
    }

    // Getter
    public IKunde getKunde(int kundenNummer) {
        return persitenz.getObjectByID(kundenNummer, Kunde.class);
    }

    // Updates
    public void updateKunde(IKunde kunde) {
        persitenz.updateObject(kunde);
    }

    // Saves
    private void saveKunde(Kunde kunde) {
        persitenz.saveObject(kunde);
    }
}
