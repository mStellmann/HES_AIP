package adapter;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;

/**
 * User: Matthias
 * Date: 22.04.13
 * Time: 20:15
 */
public class TransportdienstleisterAdapter implements ITransportdienstleisterAdapter {
    @Override
    public ITransportauftrag erstelleTransportauftrag(int transportauftragsNummer, String transportdienstleister, ILieferung lieferung) {
        return null;
    }
}
