package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    private T id;
    private boolean isVisited; // to track whether node has been visited already in Dijkstra's algorithm
    private Map<String, Object> properties;
    public Node(T id){
        this.id = id;
        this.properties = new HashMap<>();
    }

    public T getId(){
        return this.id;
    }

    public void setProperty(String property, Object value){
        properties.put(property, value);
    }

    public Object getPropertyValue(String property){
        return properties.get(property);
    }

    public void setVisited(boolean visited){
        isVisited = visited;
    }
    public boolean isVisited(){
        return this.isVisited;
    }
}
