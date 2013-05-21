package komponentenInterfaces.intern;

import interfaces.IKunde;

import java.util.List;

/**
 *
 */
public interface IKundenverwaltungIntern {
    IKunde getKunde(int kundenNummer);

    IKunde createKunde(String name, String adresse);

    List<? extends IKunde> getAllKunden();

    IKunde getKunde(String name);
}
