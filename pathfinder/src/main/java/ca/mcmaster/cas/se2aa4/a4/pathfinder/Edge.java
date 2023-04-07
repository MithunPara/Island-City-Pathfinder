package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.HashMap;
import java.util.Map;

public class Edge<N> {
    private Node<N> n1;
    private Node<N> n2;
    private double weight;
    private Map<String, Object> properties;

    public Edge(Node<N> n1, Node<N> n2, double weight){
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
        this.properties = new HashMap<>();
    }

    public Node<N> getN1(){
        return this.n1;
    }

    public Node<N> getN2(){
        return this.n2;
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
