package graph;

import graph.edge.DirectedEdge;
import graph.edge.Edge;
import graph.node.Node;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectedGraph implements Graph {
    private List<Node> nodes;
    private List<Edge> edges;

    public DirectedGraph() {
        nodes = new LinkedList<>();
        edges = new LinkedList<>();
    }

    @Override
    public void addVertex(Node node) {
        nodes.add(node);
    }

    protected Edge createEdge(Node begin, Node end) {
        return new DirectedEdge(begin, end);
    }

    @Override
    public void addEdge(Node first, Node second) {
        Edge edge = createEdge(first, second);

        if (!nodes.contains(first)) {
            nodes.add(first);
        }
        if (!nodes.contains(second)) {
            nodes.add(second);
        }

        edges.add(edge);
    }

    @Override
    public List<Edge> getPath(Node from, Node to) {

        if (!nodes.contains(from) || !nodes.contains(to) || from.equals(to)) {
            return Collections.emptyList();
        }

        Node node;
        Map<Node, Edge> friendsVisited;
        Set<Node> visitedNodes = new HashSet<>();
        Map<Node, List<Edge>> paths = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        stack.push(from);

        do {
            node = stack.pop();
            visitedNodes.add(node);

            friendsVisited = getFriendsVisited(node, visitedNodes);
            updatePaths(friendsVisited, paths);

            stack.addAll(friendsVisited.keySet());
        } while (!stack.empty() && !paths.containsKey(to));

        if (paths.containsKey(to)) {
            return paths.get(to);
        }
        return Collections.emptyList();
    }

    private Map<Node, Edge> getFriendsVisited(Node node, Set<Node> visitedNodes) {
        return edges.stream()
                .filter(edge -> edge.isNodeFirst(node))
                .filter(edge -> !visitedNodes.contains(edge.getSecondNode(node)))
                .collect(Collectors.toMap(edge -> edge.getSecondNode(node), edge -> edge));
    }

    private void updatePaths(Map<Node, Edge> friendsVisited,
                             Map<Node, List<Edge>> paths) {

        paths.putAll(friendsVisited.keySet().stream()
                .collect(Collectors.toMap(node -> node, node -> {
                    Edge edge = friendsVisited.get(node);
                    Node me = edge.getFirstNode(node);
                    List<Edge> result = new LinkedList<>();

                    paths.entrySet().stream()
                            .flatMap(e -> e.getKey().equals(me) ? Stream.of(e.getValue()) : Stream.empty())
                            .findAny()
                            .ifPresent(result::addAll);

                    result.add(edge);
                    return result;
                })));
    }

}
