package adapter;

import classes.Transportauftrag;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.*;
import interfaces.IAuftrag;
import interfaces.ITransportauftrag;
import komponentenInterfaces.intern.ITransportdienstleisterAdapter;


import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// TODO - RabbitMQ receive()
public class TransportdienstleisterAdapter implements ITransportdienstleisterAdapter {

    private Client client;
    private WebResource service;

    public TransportdienstleisterAdapter() {
        client = Client.create(new DefaultClientConfig());
        service = client.resource("http://localhost:8080/rest/tdl/");
    }

    @Override
    public ITransportauftrag verschickeAuftrag(IAuftrag auftrag) {
        service.path("verschickeTransportauftrag").accept(MediaType.TEXT_PLAIN).put("Auftragsnummer: " + auftrag.getAuftragsNummer());
        return new Transportauftrag(new Date(System.currentTimeMillis()), "DHL");
    }

    @Override
    public List<String> getAuftraege() {
        String message = service.path("auftraege").accept(MediaType.TEXT_PLAIN).get(String.class);
        return Arrays.asList(message.split("\n"));
    }
}
