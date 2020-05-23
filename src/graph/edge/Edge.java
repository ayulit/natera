package graph.edge;

import graph.node.Node;

public interface Edge {
    boolean isNodeFirst(Node node);
    Node getFirstNode(Node knownSecond);
    Node getSecondNode(Node knownFirst);
}
