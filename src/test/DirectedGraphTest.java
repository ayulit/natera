package test;

import graph.DirectedGraph;
import graph.Graph;
import graph.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    private Graph graph = new DirectedGraph();

    private Node<Character> A = new Node<>('A');
    private Node<Character> B = new Node<>('B');
    private Node<Character> C = new Node<>('C');
    private Node<Character> D = new Node<>('D');
    private Node<Character> E = new Node<>('E');
    private Node<Character> F = new Node<>('F');
    private Node<Character> G = new Node<>('G');
    private Node<Character> H = new Node<>('H');
    private Node<Character> I = new Node<>('I');

    public DirectedGraphTest() {
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(A, E);
        graph.addEdge(B, F);
        graph.addEdge(F, H);
        graph.addEdge(D, G);
        graph.addEdge(G, I);
    }

    @Test
    void getPath() {
        assertEquals(graph.getPath(A, I).toString(), "[A->D, D->G, G->I]");
    }

    @Test
    void noPathBackwards() {
        assertTrue(graph.getPath(C, A).isEmpty());
    }
}