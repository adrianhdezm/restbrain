package de.tum.sebis.restbrain.server;



import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import io.swagger.inflector.utils.CORSFilter;

import java.util.EnumSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.DispatcherType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebServer.class);

    private static final WebServer instance = new WebServer();

    public static WebServer INSTANCE() {
        return instance;
    }

    private Server server;
    private HttpServlet appServlet;


    public void setAppServlet(HttpServlet servlet){
        this.appServlet = servlet;
    }

    public void start() {

        try{
            if (server != null) {
                server.stop();
            }

            server = new Server();

            int port = 8080;
            String host = "localhost";
            String contextPath = "/";


            // HTTP connector
            ServerConnector http = new ServerConnector(server);
            http.setHost(host);
            http.setPort(port);

            // Set the connector
            server.addConnector(http);

            ServletContextHandler context = new ServletContextHandler();

            // Set the contextPath
            context.setContextPath(contextPath);
            server.setHandler(context);

            if (appServlet != null){
                context.addServlet(new ServletHolder(appServlet), "/*");
            }
            else {
                LOGGER.warn("Servlet is not initialized");
                throw new NullPointerException("Servlet is not initialized");
            }

            context.addFilter( new FilterHolder( new CORSFilter()),"/*", EnumSet.of(DispatcherType.REQUEST));

            server.start();

            System.out.println("http server started on " + host + " on port " + port);



        } catch (Exception e) {
            LOGGER.warn("Http server could not be initialized");
            System.out.println("ERROR: http server could not be initialized because of " + e.getMessage());
        }

    }

}