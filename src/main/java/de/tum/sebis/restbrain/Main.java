package de.tum.sebis.restbrain;
import de.tum.sebis.restbrain.server.WebServer;
import org.glassfish.jersey.servlet.ServletContainer;
import io.swagger.inflector.SwaggerInflector;
import  io.swagger.inflector.utils.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;

public class Main {
    public static void main( String[] args ) throws IOException {

        //set Servlet
        ServletContainer servlet = new ServletContainer(ResourceConfig.forApplicationClass(SwaggerInflector.class));

        WebServer.INSTANCE().setAppServlet(servlet);

        //set Filter
        WebServer.INSTANCE().setAppFilter(new CORSFilter());

        //start
        WebServer.INSTANCE().start();

    }

}
