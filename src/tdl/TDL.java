package tdl;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("tdl")
public class TDL {

    private static List<String> auftraege = new ArrayList<String>();

    @PUT
    @Path("verschickeAuftrag/{user}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void verschickeTransportauftrag(@PathParam("user") String user, String message) {
        auftraege.add(user + " --> " + message);
    }

    @GET
    @Path("auftraege")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuftraege() {
        return listToString(auftraege);
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
}
