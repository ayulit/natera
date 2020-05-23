package graph.node;

import java.util.Objects;

public class Node<T> {
    private T key;

    public Node(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return key.equals(node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
