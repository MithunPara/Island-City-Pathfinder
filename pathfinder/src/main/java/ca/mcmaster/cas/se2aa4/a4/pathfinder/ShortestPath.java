package ca.mcmaster.cas.se2aa4.a4.pathfinder;

import java.util.*;
import java.util.PriorityQueue;

public class ShortestPath<T> implements Path<T> {
    private Map<Node<T>, Double> nodeCost;
    private Map<Node<T>, Node<T>> parentNodes;
    private List<Node<T>> path;
    private PriorityQueue<Node<T>> queue = new PriorityQueue<>();

    public ShortestPath(){
        this.nodeCost = new HashMap<>();
        this.parentNodes = new HashMap<>();
        this.path = new ArrayList<>();
    }
    public List<Node<T>> findPath(GraphADT<T> graph, Node<T> source, Node<T> target) {
        for(Node<T> node: graph.getNodes()){
            nodeCost.put(node, Double.MAX_VALUE);
        }
        nodeCost.put(source, 0.0);
        queue.add(source);

        while(!queue.isEmpty()){
            Node<T> node = queue.poll();
            node.setVisited(true);

            if (node.equals(target)) {
                return getPath(parentNodes, node);
            }

            for (Edge<T> edge : graph.getConnectedEdges(node)) {
                Node<T> neighbourNode = edge.getNode();
                if(!neighbourNode.isVisited()) {
                    if ((nodeCost.get(node) + edge.getWeight()) < nodeCost.get(neighbourNode)) {
                        nodeCost.put(neighbourNode, nodeCost.get(node) + edge.getWeight());
                        parentNodes.put(neighbourNode, node);
                        queue.add(neighbourNode);
                    }
                }
            }
        }
        return null;
    }

    private List<Node<T>> getPath(Map<Node<T>, Node<T>> parentNodes, Node<T> targetNode){
        Node<T> node = targetNode;
        while(parentNodes.containsKey(node)){
            path.add(0, node);
            node = parentNodes.get(node);
        }
        //path.add(sourceNode); test later, not sure if first node is included in path
        return path;
    }
}
