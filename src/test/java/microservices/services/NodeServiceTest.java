package microservices.services;

import microservices.model.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeServiceTest {

    private NodeService service;

    private static final String TEST_NODE_ID = "aoo1314zca-ad1-123131-achj";

    @Before
    public void initialize() {
        service = new NodeService();
    }

    @Test
    public void testGetCachedNode() {

        Node node = service.getNodeById(TEST_NODE_ID);

        Assert.assertEquals(TEST_NODE_ID, node.getId());
    }
}
