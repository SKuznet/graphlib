package com.example.graphlib.components;

public interface Graph<T> {

    void addVertex(Vertex<T> vertex);

    void addEdge(Vertex<T> from, Vertex<T> to);

    void getPath(Vertex<T> from, Vertex<T> to);
}
