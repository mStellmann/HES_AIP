package komponentenFassaden;

import interfaces.IKunde;
import komponentenInterfaces.extern.IEinkaufsverwaltungExtern;
import komponentenInterfaces.extern.IKundenverwaltungExtern;
import komponentenInterfaces.intern.*;
import typClasses.LieferungTyp;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class EinkaufsverwaltungFassade implements IEinkaufsverwaltungIntern, IEinkaufsverwaltungExtern {
    // DUMMY
    private IPersitenz persitenz;
    private IProduktverwaltungIntern produktverwaltungIntern;
    private ILieferantenverwaltungIntern lieferantenverwaltungIntern;

    public EinkaufsverwaltungFassade(IPersitenz persitenz, IProduktverwaltungIntern produktverwaltungIntern, ILieferantenverwaltungIntern lieferantenverwaltungIntern) {
        this.persitenz = persitenz;
        this.produktverwaltungIntern = produktverwaltungIntern;
        this.lieferantenverwaltungIntern = lieferantenverwaltungIntern;
    }

    @Override
    public LieferungTyp wareBestellen(int warenNr) {
        return null;
    }
}
