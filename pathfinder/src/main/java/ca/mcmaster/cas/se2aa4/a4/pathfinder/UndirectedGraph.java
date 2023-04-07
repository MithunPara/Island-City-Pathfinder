package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph<N,E> {
    private List<N> nodes;
    private List<E> edges;

    public UndirectedGraph(){
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(N node){
        nodes.add(node);
    }

    public void addEdge(E edge){
        edges.add(edge);
    }

    public List<N> getNodes(){
        return this.nodes;
    }

    public List<E> getEdges(){
        return this.edges;
    }
}
