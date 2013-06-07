package tdl;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement
public class TDL {

    public List<String> auftraege;

    public TDL() {
        auftraege = new ArrayList<String>();
        auftraege.add("fhsjklhflks");
        auftraege.add("dfsdfa");
        auftraege.add("fsdfsd");
        auftraege.add("sdfsdsdfsd");
    }

    @PUT
    @Path("auftrag_verschicken/{vonWEM}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void verschickeTransportauftrag(@PathParam("vonWEM") String vonWEM, String message) {
        auftraege.add("Auftrag erteilt von: " + vonWEM + " --> " + message);
    }


    private String listToString(List<String> list) {
        String newString = "";
        int i = 1;
        for (String string : list) {
            newString = newString + i + ". " + string + "\n";
            i++;
        }
        return newString;
    }

    @GET
    @Path("auftraege")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuftraege() {
        return listToString(auftraege);
    }

}
