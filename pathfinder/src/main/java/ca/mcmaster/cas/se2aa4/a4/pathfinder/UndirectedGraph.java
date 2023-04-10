package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class UndirectedGraph<N,E> implements GraphADT<N,E> {
    private List<N> nodes;
    private List<Edge<N>> edges;
    private Map<N, ArrayList<Edge<N>>> adjacencyList;

    public UndirectedGraph(){
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(N node){
        adjacencyList.put(node, new ArrayList<>());
        nodes.add(node);
    }

    public void addEdge(N n1, N n2, double weight, Map<String, Object> properties){
        Edge<N> edge = new Edge<>(n2, weight);
        for(Map.Entry<String, Object> entry: properties.entrySet()){
            edge.setProperty(entry.getKey(), entry.getValue());
        }
        adjacencyList.get(n1).add(edge);
        edges.add(edge);

        // add edge in other direction because graph is undirected
        edge = new Edge<>(n1, weight);
        for(Map.Entry<String, Object> entry: properties.entrySet()){
            edge.setProperty(entry.getKey(), entry.getValue());
        }
        adjacencyList.get(n2).add(edge);
        edges.add(edge);
    }

    public boolean containsNode(N node){ // maybe modify the node methods, right now the nodes must be created with their id
                                         // from the island then added to graph
        return nodes.contains(node);
    }
//    public boolean containsEdge (E edge){ // do we need this method bc not adding any edges to graph directly from
                                            // island with type Edge already (Update interface later)
//
//    }
    public double getEdgeWeight(N n1, N n2){
        for(Edge<N> edge: adjacencyList.get(n1)){
            if (edge.getNode().equals(n2)){
                return edge.getWeight();
            }
        }
        return Double.MAX_VALUE;
    }

    public List<N> getNodes(){
        return this.nodes;
    }

    public List<Edge<N>> getEdges(){
        return this.edges;
    }

    public List<Edge<N>> getConnectedEdges(N source){
        return adjacencyList.get(source);
    }
}
