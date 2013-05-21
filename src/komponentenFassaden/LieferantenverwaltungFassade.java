package komponentenFassaden;

import komponentenInterfaces.extern.ILieferantenverwaltungExtern;
import komponentenInterfaces.intern.ILieferantenverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
public class LieferantenverwaltungFassade implements ILieferantenverwaltungIntern, ILieferantenverwaltungExtern {
    private IPersitenz persitenz;

    public LieferantenverwaltungFassade(IPersitenz persitenz) {
        this.persitenz = persitenz;
    }
}
