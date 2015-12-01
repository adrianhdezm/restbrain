package de.tum.sebis.restbrain;

import de.tum.sebis.restbrain.server.WebServer;

import org.glassfish.jersey.servlet.ServletContainer;

import io.swagger.inflector.config.Configuration;
import io.swagger.inflector.SwaggerInflector;

public class Main {
    public static void main( String[] args ) throws Exception {

        if( args.length != 1 ) {
            System.out.println( "Usage: java -jar ./target/restbrain-0.1.jar config/<options.yml>" );
            return;
        }

        SwaggerInflector inflector = new SwaggerInflector(Configuration.read(args[0]));

        //set Servlet
        ServletContainer servlet = new ServletContainer(inflector);
        WebServer.INSTANCE().setAppServlet(servlet);


        //start
        WebServer.INSTANCE().start();

    }

}
