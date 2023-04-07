package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph<N,E> implements GraphADT<N,E> {
    private List<N> nodes;
    private List<E> edges;

    public UndirectedGraph(){
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(N node){
        nodes.add(node);
    }

    public void addEdge(N node1, N node2, double weight){
        edges.add(edge);
    }

    public boolean containsNode(N node){

    }
    public boolean containsEdge (E edge){

    }
    public double getEdgeWeight(N n1, N n2){

    }

    public List<N> getNodes(){
        return this.nodes;
    }

    public List<E> getEdges(){
        return this.edges;
    }
}
