package test.node;

import graph.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NodeTest {

    private Node<Character> a = new Node<>('A');
    private Node<Character> x = new Node<>('A');
    private Node<Character> b = new Node<>('B');

    @Test
    void testEquals() {
        assertEquals(a, x);
    }

    @Test
    void notEquals() {
        assertNotEquals(a, b);
    }

    @Test
    void testHashCode() {
        assertEquals(a.hashCode(), x.hashCode());
    }

    @Test
    void differentHashCode() {
        assertNotEquals(a.hashCode(), b.hashCode());
    }
}