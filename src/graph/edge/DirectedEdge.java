package graph.edge;

import graph.node.Node;

public class DirectedEdge implements Edge {

    private Node begin;
    private Node end;

    public DirectedEdge(Node begin, Node end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean isNodeFirst(Node node) {
        return begin.equals(node);
    }

    @Override
    public Node getFirstNode(Node knownSecond) {
        return begin;
    }

    @Override
    public Node getSecondNode(Node knownFirst) {
        return end;
    }

    @Override
    public String toString(){
        return begin.toString() + "->" + end.toString();
    }
}
