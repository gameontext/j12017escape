package application.rest.v1;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;

import javax.inject.Inject;
import application.bluemix.ServiceName;
import com.cloudant.client.api.CloudantClient;

@Path("v1/example")
public class Example {

    @Inject
    @ServiceName(name="j12017escape-cloudantno-1506936539245")
    protected CloudantClient client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response example() {
        List<String> list = new ArrayList<>();
        //return a simple list of strings
        list.add("Some data");
        return Response.ok(list.toString()).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("cloudant")
    public Response exampleCloudant() {
        List<String> list = new ArrayList<>();
        try {
            list = client.getAllDbs();
        } catch (NullPointerException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return Response.ok("The magic word to escape the room is : " + list.toString()).build();
    }

}
