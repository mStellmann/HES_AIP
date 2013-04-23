package komponentenInterfaces.intern;

import interfaces.IKunde;

/**
 *
 */
public interface IKundenverwaltungIntern {
    IKunde getKunde(int kundenNummer);

    IKunde createKunde(String name, String adresse);
}
