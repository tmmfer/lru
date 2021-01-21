package microservices.services;

import microservices.model.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeServiceTest {

    private LRUCacheService service;

    private static final String TEST_NODE_ID = "aoo1314zca-ad1-123131-achj";

    @Before
    public void initialize() {
        service = new LRUCacheService();
    }

    @Test
    public void testNodeNotInCache() {

        Node node = new Node();

        boolean isInCache = service.isInCache(node.getId());

        Assert.assertFalse(isInCache);
    }

    @Test
    public void testNodeInCache() {
        Node node = Node.NodeBuilder.aNode().withId(TEST_NODE_ID).build();
        service.placeInCache(node);
        Assert.assertTrue(service.isInCache(TEST_NODE_ID));
    }

    @Test
    public void testGetCachedNode() {
        Node node = Node.NodeBuilder.aNode().withId(TEST_NODE_ID).build();
        service.placeInCache(node);

        Node nodeFromCache = service.getCachedNode(TEST_NODE_ID);

        Assert.assertEquals(TEST_NODE_ID, nodeFromCache.getId());
    }
}
