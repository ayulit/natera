package test;

import graph.Graph;
import graph.UndirectedGraph;
import graph.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UndirectedGraphTest {

    private Graph graph = new UndirectedGraph();

    private Node<Character> A = new Node<>('A');
    private Node<Character> B = new Node<>('B');
    private Node<Character> C = new Node<>('C');
    private Node<Character> D = new Node<>('D');
    private Node<Character> E = new Node<>('E');
    private Node<Character> F = new Node<>('F');
    private Node<Character> G = new Node<>('G');
    private Node<Character> H = new Node<>('H');
    private Node<Character> I = new Node<>('I');

    private Node<Character> X = new Node<>('X');
    private Node<Character> Y = new Node<>('Y');

    public UndirectedGraphTest() {
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(A, E);
        graph.addEdge(B, F);
        graph.addEdge(F, H);
        graph.addEdge(D, G);
        graph.addEdge(G, I);

        graph.addEdge(X, Y);
    }

    @Test
    void getPath() {
        assertEquals(graph.getPath(H, I).toString(), "[F-H, B-F, A-B, A-D, D-G, G-I]");
    }

    @Test
    void noPath() {
        assertTrue(graph.getPath(A, Y).isEmpty());
    }

    @Test
    void trivialPath() {
        assertTrue(graph.getPath(A, A).isEmpty());
    }
}