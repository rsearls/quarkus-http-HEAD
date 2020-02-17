package org.jboss.resteasy.test.core.basic.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/lang")
public class ByeResource {

    @GET
    @Produces("text/plain")
    @Path("bye")
    public String goodBy() {
        return "Good Bye !!";
    }
}
