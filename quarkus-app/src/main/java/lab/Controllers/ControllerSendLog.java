package lab.Controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@Path("/sendlog")
public class ControllerSendLog {
    private static final Logger LOG = Logger.getLogger(ControllerSendLog.class);
    @GET
    public String sendlog() {
        LOG.info("Моя запись в лог");
        return "Моя запись в лог";
    }
}
