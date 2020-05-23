package test.edge;

import graph.edge.DirectedEdge;
import graph.edge.Edge;
import graph.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DirectedEdgeTest {

    private Node<Character> beginNode = new Node<>('A');
    private Node<Character> endNode = new Node<>('B');
    private Edge edge = new DirectedEdge(beginNode, endNode);

    @Test
    void isNodeFirst() {
        assertTrue(edge.isNodeFirst(beginNode));
        assertFalse(edge.isNodeFirst(endNode));
    }

    @Test
    void getFirstNode() {
        assertEquals(beginNode, edge.getFirstNode(beginNode));
        assertEquals(beginNode, edge.getFirstNode(endNode));
    }

    @Test
    void getSecondNode() {
        assertEquals(endNode, edge.getSecondNode(beginNode));
        assertEquals(endNode, edge.getSecondNode(endNode));
    }

    @Test
    void testToString() {
        assertEquals(edge.toString(), "A->B");
    }
}