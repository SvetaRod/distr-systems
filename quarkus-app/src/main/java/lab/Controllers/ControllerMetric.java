package lab.Controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lab.Metrics.RandomMetric;

@Path("/metric")
public class ControllerMetric {

    @Inject
    RandomMetric randomMetric;

    @GET
    @Path("/random")
    public String random() {
        randomMetric.random();
        return "Random";
    }
}
