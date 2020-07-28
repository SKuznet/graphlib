package com.example.graphlib.components;

public class DirectedGraph<T> extends AbstractGraph<T> {

    @Override
    public void addEdge(Vertex<T> from, Vertex<T> to) {

        if (from.equals(to)) {
            throw new IllegalArgumentException("Please connect different vertices.");
        }

        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("One or both vertices are not part of the graph.");
        }

        connect(from, to);
    }

    private void connect(Vertex<T> source, Vertex<T> dest) {
        graph.get(source).add(dest);
    }
}
