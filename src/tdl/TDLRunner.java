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

public class TDLRunner {

    public static void main(String args[]) {
        HttpServer server = null;
        try {
            server = HttpServerFactory.create("http://localhost:8080/rest");
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();
        JOptionPane.showMessageDialog(null, "Ende");
        server.stop(0);
    }


}
