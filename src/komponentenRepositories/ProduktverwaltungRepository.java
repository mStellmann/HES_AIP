package komponentenRepositories;

import classes.Kunde;
import classes.Produkt;
import interfaces.IKunde;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;

public class ProduktverwaltungRepository {
    private IPersitenz persitenz;

    public ProduktverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IProdukt erstelleProdukt(int produktNummer, String name, int lagerbestand) {
        return new Produkt(produktNummer, name, lagerbestand);
    }

    // Getter
    public IProdukt getProdukt(int kundenNummer) {
        return null; // todo
    }

    // Updates
    public void updateProdukt(IKunde kunde) {
        // todo
    }

    // Saves
    private void saveProdukt(Kunde kunde) {
        // todo
    }
}
