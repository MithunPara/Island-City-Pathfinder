package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.Map;

public interface GraphADT <N, E> {
    public void addNode(N node);
    public void addEdge(N n1, N n2, double weight, Map<String, Object> properties);
    public boolean containsNode(N node);
//    public boolean containsEdge (E edge);
    public double getEdgeWeight(N n1, N n2);

}
