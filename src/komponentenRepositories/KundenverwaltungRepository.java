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

    public IKunde erstelleKunde(int kundenNummer, String name, String adresse) {
        return new Kunde(kundenNummer, name, adresse);
    }

    // Getter
    public IKunde getKunde(int kundenNummer) {
        return null; // todo
    }

    // Updates
    public void updateKunde(IKunde kunde) {
        // todo
    }

    // Saves
    private void saveKunde(Kunde kunde) {
        // todo
    }
}
