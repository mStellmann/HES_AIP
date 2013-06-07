package tdl;

import com.sun.net.httpserver.*;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;

import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Path( "TDL" )
public class TDLRunner {
//    public List<String> auftraege;
//
//    public TDLRunner() {
//        auftraege = new ArrayList<String>();
//    }

//    @PUT
//    @Path("verschickeTransportauftrag/{message}")
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String verschickeTransportauftrag(@PathParam("message") String message) {
//        auftraege.add(message);
//        return "Auftrag: " + message + " erfolgreich verschickt!";
//    }
//
//    @GET
//    @Path( "Auftraege" )
//    @Produces( MediaType.TEXT_PLAIN )
//    List<String> getAuftraege() {
//        return auftraege;
//    }

    public static void main(String args[]) {
        HttpServer server = null;
        try {
            server = HttpServerFactory.create("http://localhost:8080/TDL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();
        JOptionPane.showMessageDialog(null, "Ende");
        server.stop(0);
    }


}
