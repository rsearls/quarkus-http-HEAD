package org.jboss.resteasy.test.core.basic;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.resteasy.spi.HttpResponseCodes;
import org.jboss.resteasy.test.core.basic.resource.ByeResource;
import org.jboss.resteasy.utils.PortProviderUtil;
import org.jboss.resteasy.utils.TestUtil;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@RunWith(Arquillian.class)
@RunAsClient
public class ByeTest {
    @Deployment
    public static Archive<?> deploy() {
        WebArchive war = TestUtil.prepareArchive(ByeTest.class.getSimpleName());
        return TestUtil.finishContainerPrepare(war, null, ByeResource.class);
    }

    @Test
    public void testBye() throws Exception {
        Client client = ClientBuilder.newClient();
        String x = PortProviderUtil.generateURL("/lang/bye",
                ByeTest.class.getSimpleName()); // rls debug
        WebTarget base = client.target(PortProviderUtil.generateURL("/lang/bye",
                ByeTest.class.getSimpleName()));
        Response response = base.request().get();

        Assert.assertEquals(response.getStatus(), HttpResponseCodes.SC_OK);

        response.close();
        client.close();
    }
}
