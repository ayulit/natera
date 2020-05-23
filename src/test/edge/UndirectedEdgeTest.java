package test.edge;

import graph.edge.Edge;
import graph.edge.UndirectedEdge;
import graph.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UndirectedEdgeTest {

    private Node<Character> firstNode = new Node<>('A');
    private Node<Character> secondNode = new Node<>('B');
    private Edge edge = new UndirectedEdge(firstNode, secondNode);

    @Test
    void isNodeFirst() {
        assertTrue(edge.isNodeFirst(firstNode));
        assertTrue(edge.isNodeFirst(secondNode));
    }

    @Test
    void getFirstNode() {
        assertEquals(firstNode, edge.getFirstNode(secondNode));
    }

    @Test
    void getSecondNode() {
        assertEquals(secondNode, edge.getSecondNode(firstNode));
    }

    @Test
    void testToString() {
        assertEquals(edge.toString(), "A-B");
    }
}