package komponentenFassaden;

import interfaces.IProdukt;
import komponentenInterfaces.extern.IProduktverwaltungExtern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.ProduktverwaltungRepository;

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

    public ProduktverwaltungFassade(IPersitenz persistenz){
        this.repository = new ProduktverwaltungRepository(persistenz);
    }

    @Override
    public void lagerbestendReduzieren(int rausgehendeMenge) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean nrIstVorhanden(int warenNr) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IProdukt getProdukt(int warenNr) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
