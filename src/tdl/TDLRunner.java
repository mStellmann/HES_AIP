package tdl;

import com.sun.net.httpserver.*;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import javax.swing.*;


public class TDLRunner {
    // TODO - main() - rcv von Jersey
    // https://jersey.java.net/nonav/documentation/latest/client.html

           public static void main(String args[]) {
               HttpServer server = HttpServerFactory.create( "http://localhost:8080/rest" );
               server.start();
               JOptionPane.showMessageDialog( null, "Ende" );
               server.stop( 0 );
        }


}
