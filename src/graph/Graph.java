package graph;

import graph.edge.Edge;
import graph.node.Node;

import java.util.List;

public interface Graph {
    void addVertex(Node node);
    void addEdge(Node first, Node second);
    List<Edge> getPath(Node from, Node to );
}
