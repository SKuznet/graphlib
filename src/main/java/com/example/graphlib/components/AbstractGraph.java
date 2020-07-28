package com.example.graphlib.components;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {

    protected Map<Vertex<T>, Set<Vertex<T>>> graph = new HashMap<>();
    protected List<Vertex<T>> currentPath = new ArrayList<>();

    public void addVertex(Vertex<T> vertex) {
        if (graph.containsKey(vertex)) {
            throw new IllegalArgumentException("The vertex is already part of the graph.");
        } else {
            graph.put(vertex, new HashSet<>());
        }
    }

    @Override
    public void getPath(Vertex<T> from, Vertex<T> to) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("One or both vertices are not part of the graph.");
        }

        currentPath.add(from);
        from.setVisited(true);

        if (from.equals(to)) {
            System.out.print(Arrays.toString(currentPath.toArray()));

            return;
        }

        boolean allConnectedVerticesVisited = graph.get(from).stream()
                .allMatch(Vertex::isVisited);

        if (allConnectedVerticesVisited) {
            if (!currentPath.isEmpty()) {
                currentPath.remove(currentPath.size() - 1);
            }
            return;
        }

        graph.get(from).stream()
                .filter(vertex -> !vertex.isVisited())
                .forEach(vertex -> getPath(vertex, to));
    }
}
