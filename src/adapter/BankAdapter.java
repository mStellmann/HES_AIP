package adapter;

import classes.Zahlungseingang;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import interfaces.IZahlungseingang;
import komponentenInterfaces.intern.IBankAdapter;
import org.javatuples.Pair;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.IOException;
import java.util.Date;

// TODO - Jersey sendToTDL()
public class BankAdapter implements IBankAdapter {

    private final static String QUEUE_NAME = "Zahlungseingang";
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private QueueingConsumer consumer;

        public BankAdapter() throws IOException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        }





    @Override
    public Pair<IZahlungseingang, Integer> getNaechstenZahlungseingang() throws InterruptedException {
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
        String message = new String(delivery.getBody());

        System.out.println(" [x] Received '" + message + "'");

        String[] messageSplit = message.split(" ");
        int rechnungsNummer   = Integer.getInteger(messageSplit[0]);
        int betrag      = Integer.getInteger(messageSplit[1]);
        IZahlungseingang zahlungseingang = new Zahlungseingang(new Date(),betrag);
        Pair<IZahlungseingang, Integer> rueckgabe = Pair.with(zahlungseingang, rechnungsNummer);
        return rueckgabe;
    }
}
