package komponentenFassaden;

import komponentenInterfaces.extern.ILagerverwaltungExtern;
import komponentenInterfaces.intern.IEinkaufsverwaltungIntern;
import komponentenInterfaces.intern.ILagerverwaltungIntern;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenLogik.LagerverwaltungLogik;
import komponentenRepositories.LagerverwaltungRepository;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class LagerverwaltungFassade implements ILagerverwaltungIntern, ILagerverwaltungExtern {
    private LagerverwaltungLogik logik;
    private LagerverwaltungRepository repositorie;

    public LagerverwaltungFassade(IProduktverwaltungIntern produkt, IEinkaufsverwaltungIntern einkauf) {

        repositorie = new LagerverwaltungRepository();
        logik = new LagerverwaltungLogik(repositorie, produkt, einkauf);
    }
}
