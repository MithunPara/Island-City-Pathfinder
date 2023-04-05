package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.HashMap;
import java.util.Map;

public class Node<T> {
    private T id;
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
}
