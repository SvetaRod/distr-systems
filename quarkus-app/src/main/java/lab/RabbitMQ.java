package lab;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lab.objects.Message;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Path("/message")
@ApplicationScoped
public class RabbitMQ {
    @Channel("outgoing-requests")
    Emitter<String> quoteRequestEmitter;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMessage(Message message) {
        quoteRequestEmitter.send(message.getText());
    }

    @Incoming("incoming-requests")
    public void messageHandler(String message){
        Log.info(message);
    }
}
