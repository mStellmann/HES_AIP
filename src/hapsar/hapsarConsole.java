package hapsar;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.javatuples.Tuple;

import java.util.Scanner;

/**
 *
 */
public class HAPSARConsole {
    // TODO - main() + console -> writeToQueue() [publish]
    // https://github.com/rabbitmq/rabbitmq-tutorials/tree/master/java

    private final static String QUEUE_NAME = "Zahlungseingang";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 2 Parameter auf true setzen wenn wir queue Declare in die schleife verschieben
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Scanner sc = new Scanner(System.in);


        String message = null;

        while(!message.equals("exit")){
        System.out.println("Bitte geben sie die Rechnungsnummer und den Betrag durch ein Leerzeichen getrennt ein:");

        message = sc.nextLine();


        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        }


        channel.close();
        connection.close();

    }
}
