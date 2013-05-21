package komponentenRepositories;

import classes.Kunde;
import classes.Produkt;
import interfaces.IKunde;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IPersitenz;

import java.util.Date;
import java.util.List;

public class ProduktverwaltungRepository {
    private IPersitenz persitenz;

    public ProduktverwaltungRepository(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }

    public IProdukt erstelleProdukt(String name, int lagerbestand) {
        Produkt produkt = new Produkt(name, lagerbestand);
        persitenz.saveObject(produkt);
        return produkt;

    }

    // Getter
    public IProdukt getProdukt(int produktNummer) {
        return persitenz.getObjectByID(produktNummer, Produkt.class);
    }

    // Updates
    public void updateProdukt(IProdukt produkt) {
        persitenz.updateObject(produkt);
    }

    // Saves
    private void saveProdukt(Produkt produkt) {
        persitenz.saveObject(produkt);
    }

    public List<? extends IProdukt> getAllProdukte() {
        return persitenz.getAllObjects(Produkt.class);
    }

    public IProdukt getProdukt(String name) {
        return persitenz.searchObjectByName(name, Produkt.class);
    }
}
