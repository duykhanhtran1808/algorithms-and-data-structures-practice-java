package algorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    // private int numOfNodes;
    private HashMap<Integer, LinkedList<Integer>> graph;

    public Graph() {
        // this.numOfNodes = 0;
        this.graph = new HashMap<>();
    }

    public void addVertex(int node) {
        // this.numOfNodes++;
        LinkedList<Integer> adj_list = new LinkedList<>();
        this.graph.put(node, adj_list);
    }

    public void addEdge (int node1, int node2) {
        LinkedList<Integer> current_adj_list = this.graph.get(node1);
        current_adj_list.add(node2);
        this.graph.put(node1, current_adj_list);

        current_adj_list = this.graph.get(node2);
        current_adj_list.add(node1);
        this.graph.put(node2, current_adj_list);
    }

    public void showConnections() {
        for(int key: this.graph.keySet()) {
            System.out.print(key + ": ");
            for(int item: this.graph.get(key)) {
                System.out.print(item);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.showConnections();
    }
}
