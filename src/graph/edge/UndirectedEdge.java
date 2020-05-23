package graph.edge;

import graph.node.Node;

public class UndirectedEdge implements Edge {

    private Node first;
    private Node second;

    public UndirectedEdge(Node first, Node second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isNodeFirst(Node node) {
        return (first.equals(node) || second.equals(node) );
    }

    @Override
    public Node getFirstNode(Node knownSecond) {
        return second.equals(knownSecond) ? first : second;
    }

    @Override
    public Node getSecondNode(Node knownFirst) {
        return first.equals(knownFirst) ? second : first;
    }

    @Override
    public String toString(){
        return first.toString() + "-" + second.toString();
    }
}
