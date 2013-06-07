package tdl;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 07.06.13
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */

@Path("tdl")
public class TDL {

//    public List<String> auftraege;
//
//    public TDL() {
//        auftraege = new ArrayList<String>();
//        auftraege.add("fhsjklhflks");
//    }

//    @PUT
//    @Path("verschickeTransportauftrag/{message}")
//    @Consumes(MediaType.TEXT_PLAIN)
//    public String verschickeTransportauftrag(@PathParam("message") String message) {
////        auftraege.add(message);
//        return "Auftrag: " + message + " erfolgreich verschickt!";
//    }

    @GET
    @Path("auftraege")
//    @Produces(MediaType.TEXT_PLAIN)
    String getAuftraege() {
        return "sadasdsadsa";
    }

}
