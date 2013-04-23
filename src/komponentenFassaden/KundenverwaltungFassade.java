package komponentenFassaden;

import interfaces.IKunde;
import komponentenInterfaces.extern.IKundenverwaltungExtern;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenRepositories.KundenverwaltungRepository;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
public class KundenverwaltungFassade implements IKundenverwaltungIntern, IKundenverwaltungExtern {

    //private ProduktverwaltungLogik logik;
    private KundenverwaltungRepository repository;

    public KundenverwaltungFassade(IPersitenz persistenz){
        this.repository = new KundenverwaltungRepository(persistenz);
    }

    @Override
    public IKunde getKunde(int kundenNummer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
