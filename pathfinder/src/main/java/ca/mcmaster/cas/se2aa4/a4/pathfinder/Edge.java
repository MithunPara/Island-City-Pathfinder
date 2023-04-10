package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.HashMap;
import java.util.Map;

public class Edge<N> {
    private N node;
    private double weight;
    private Map<String, Object> properties;

    public Edge(N node, double weight){
        this.node = node;
        this.weight = weight;
        this.properties = new HashMap<>();
    }

    public N getNode(){
        return this.node;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setProperty(String property, Object value){
        properties.put(property, value);
    }

    public Object getPropertyValue(String property){
        return properties.get(property);
    }
}
