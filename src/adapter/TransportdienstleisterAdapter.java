package adapter;

import interfaces.IAuftrag;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;


import java.util.List;

// TODO - RabbitMQ receive()
public class TransportdienstleisterAdapter implements ITransportdienstleisterAdapter {

    @Override
    public ITransportauftrag verschickeAuftrag(IAuftrag auftrag) {
        return null;
    }

    @Override
    public List<String> getAuftaege() {
        return null;
    }
}
