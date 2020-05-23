package graph;

import graph.edge.Edge;
import graph.edge.UndirectedEdge;
import graph.node.Node;

public class UndirectedGraph extends DirectedGraph {
    @Override
    protected Edge createEdge(Node begin, Node end) {
        return new UndirectedEdge(begin, end);
    }
}
