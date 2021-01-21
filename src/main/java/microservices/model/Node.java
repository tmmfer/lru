package microservices.model;

import microservices.utils.NodeUtils;

import java.util.List;

public class Node {

    private String id;

    private Node parent;

    private List<Node> children;

    @Override
    public boolean equals(Object o) {
        return NodeUtils.isEqual(this, o);
    }

    @Override
    public int hashCode() {
        return NodeUtils.generateHashCode(this);
    }

    public static final class NodeBuilder {
        private Node parent;
        private List<Node> children;
        private String id;

        private NodeBuilder() {
        }

        public static NodeBuilder aNode() {
            return new NodeBuilder();
        }

        public NodeBuilder withParent(Node parent) {
            this.parent = parent;
            return this;
        }

        public NodeBuilder withChildren(List<Node> children) {
            this.children = children;
            return this;
        }

        public NodeBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public Node build() {
            Node node = new Node();
            node.setChildren(children);
            node.id = this.id;
            node.parent = this.parent;
            return node;
        }
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getId() {
        return id;
    }
}
