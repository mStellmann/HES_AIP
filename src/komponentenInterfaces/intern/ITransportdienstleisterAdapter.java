package komponentenInterfaces.intern;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 21:05
 */
public interface ITransportdienstleisterAdapter {
    void verschickeTransportauftrag(ILieferung lieferung);
}
