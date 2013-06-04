package adapter;

import interfaces.ILieferung;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

// TODO - RabbitMQ receive()
public class TransportdienstleisterAdapter implements ITransportdienstleisterAdapter {
    @Override
    public void verschickeTransportauftrag(ILieferung lieferung) {
        // TODO
    }
}
