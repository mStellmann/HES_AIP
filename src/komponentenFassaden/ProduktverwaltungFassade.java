package komponentenFassaden;

import interfaces.IProdukt;
import komponentenInterfaces.extern.IProduktverwaltungExtern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.ProduktverwaltungRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
public class ProduktverwaltungFassade implements IProduktverwaltungIntern, IProduktverwaltungExtern {

    //private ProduktverwaltungLogik logik;
    private ProduktverwaltungRepository repository;

    public ProduktverwaltungFassade(IPersitenz persistenz) {
        this.repository = new ProduktverwaltungRepository(persistenz);
    }

    @Override
    public void lagerbestendReduzieren(int rausgehendeMenge) {

    }

    @Override
    public boolean nrIstVorhanden(int warenNr) {
        return false;
    }

    @Override
    public IProdukt getProdukt(int warenNr) {
        return repository.getProdukt(warenNr);
    }

    @Override
    public IProdukt createProdukt(String name, int lagerbestand) {
        return repository.erstelleProdukt(name, lagerbestand);
    }

    @Override
    public List<? extends IProdukt> getAllProdukte() {
        return repository.getAllProdukte();
    }

    @Override
    public IProdukt getProdukt(String name) {
        return repository.getProdukt(name);
    }
}
