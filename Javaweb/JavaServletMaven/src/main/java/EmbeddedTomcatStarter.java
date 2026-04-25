import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbeddedTomcatStarter {
    public static void main(String[] args) throws LifecycleException {
        
        // Default port
        int port = 5000;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number, using default 5000");
            }
        }

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setHostname("0.0.0.0");
        tomcat.setBaseDir("tomcat." + port);
        
        // Force creation of the HTTP connector
        tomcat.getConnector();

        // Set up the web application without automatic JSP servlet
        String webappDirLocation = "src/main/webapp/";
        Context ctx = tomcat.addContext("", new File(webappDirLocation).getAbsolutePath());
        
        // Configure the default servlet for static resources
        Tomcat.addServlet(ctx, "default", new org.apache.catalina.servlets.DefaultServlet());
        ctx.addServletMappingDecoded("/", "default");
        
        // Manually register the PersonaControladorServlet since @WebServlet is disabled
        try {
            Class<?> servletClass = Class.forName("controlador.PersonaControladorServlet");
            Tomcat.addServlet(ctx, "persona", (javax.servlet.Servlet) servletClass.getDeclaredConstructor().newInstance());
            ctx.addServletMappingDecoded("/persona", "persona");
        } catch (Exception e) {
            System.err.println("Failed to register PersonaControladorServlet: " + e.getMessage());
            e.printStackTrace();
        }

        tomcat.start();
        System.out.println("Tomcat started on port " + port);
        System.out.println("Application URL: http://localhost:" + port + "/");
        System.out.println("Server is waiting for requests...");
        
        // Keep the server running
        tomcat.getServer().await();
    }
}