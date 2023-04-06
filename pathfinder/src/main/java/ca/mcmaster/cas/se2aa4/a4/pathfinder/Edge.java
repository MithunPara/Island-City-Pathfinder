package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.HashMap;
import java.util.Map;

public class Edge<T> {
    private Node<T> n1;
    private Node<T> n2;
    private double weight;
    private Map<String, Object> properties;

    public Edge(Node<T> n1, Node<T> n2){
        this.n1 = n1;
        this.n2 = n2;
        this.properties = new HashMap<>();
    }

    public Node<T> getN1(){
        return this.n1;
    }

    public Node<T> getN2(){
        return this.n2;
    }

    public double getWeight(){
        return this.weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setProperty(String property, Object value){
        properties.put(property, value);
    }

    public Object getPropertyValue(String property){
        return properties.get(property);
    }
}
