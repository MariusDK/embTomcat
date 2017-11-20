import java.io.*;
import org.apache.catalina.*;
import org.apache.catalina.core.*;
import org.apache.catalina.webresources.*;
import org.apache.catalina.startup.*;
import p.Adauga;
public class TomcatServer {
    public static void main(String[] args) throws Exception {
        Tomcat server = new Tomcat();
        server.setPort(8080);
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = server.addContext("/",base.getAbsolutePath());
        Tomcat.addServlet(rootCtx, "Add", new Adauga());
        rootCtx.addServletMapping("/*", "Add");
        System.out.println("Start server Tomcat embedded");
        server.start();
        server.getServer().await();
    }
}