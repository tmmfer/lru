package microservices.services;

import microservices.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NodeService {

    private LRUCacheService cacheService;
    private List<Node> dbStorage = new ArrayList<Node>();

    public NodeService() {
        cacheService = new LRUCacheService();
        dbStorage.add(Node.NodeBuilder.aNode().withId("1").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("2").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("3").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("4").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("5").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("6").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("7").build());
        dbStorage.add(Node.NodeBuilder.aNode().withId("8").build());
    }


    public Node getNodeById(String id) {
        if (!cacheService.isInCache(id)) {
            cacheService.placeInCache(findNode(id));
        }
        return cacheService.getCachedNode(id);
    }


    private Node findNode(final String nodeId) {
        Optional<Node> filteredNode = dbStorage.stream().filter(node -> node.getId().equals(nodeId)).findFirst();
        if (filteredNode.isPresent()) {
            return filteredNode.get();
        }
        return null;
    }
}
