package komponentenFassaden;

import interfaces.IKunde;
import komponentenInterfaces.extern.IKundenverwaltungExtern;
import komponentenInterfaces.intern.IKundenverwaltungIntern;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class EinkaufsverwaltungFassade implements IKundenverwaltungIntern, IKundenverwaltungExtern {
    @Override
    public IKunde getKunde(int kundenNummer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
