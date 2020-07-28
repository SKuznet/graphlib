package com.example.graphlib.components;

import org.junit.Test;

public class UndirectedGraphTest {

    @Test
    public void test() {
        Graph graph = new DirectedGraph<Integer>();
        Vertex<Integer> vertex1 = new Vertex<>(1);
        graph.addVertex(vertex1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        graph.addVertex(vertex2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        graph.addVertex(vertex3);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);

        graph.getPath(vertex1, vertex3);

    }
}
