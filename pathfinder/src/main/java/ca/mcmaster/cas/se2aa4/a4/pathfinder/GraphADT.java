package ca.mcmaster.cas.se2aa4.a4.pathfinder;

public interface GraphADT <N, E> {
    public void addNode(N node);
    public void addEdge(N n1, N n2, int weight);
    public boolean containsNode(N node);
    public boolean containsEdge (E edge);
    public double getEdgeWeight(N n1, N n2);

}
