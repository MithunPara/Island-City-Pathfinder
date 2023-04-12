package ca.mcmaster.cas.se2aa4.a3.island.Networks;

import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.Tile;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileSegment;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileVertex;
import ca.mcmaster.cas.se2aa4.a3.island.Terrains.LandTerrains.CityType;
import ca.mcmaster.cas.se2aa4.a3.island.Terrains.LandTerrains.Land;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.Edge;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.Node;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.ShortestPath;
import ca.mcmaster.cas.se2aa4.a4.pathfinder.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class StarNetwork {
    private UndirectedGraph<TileVertex> graph;
    private List<Node<TileVertex>> cities;
    private List<Node<TileVertex>> nodePath;
    private Node<TileVertex> centralHub;
    private List<TileVertex> cityCentroids;
    private List<Edge<TileVertex>> pathEdges;
    private List<Land> networkArea;
    public StarNetwork(UndirectedGraph<TileVertex> graph, List<Node<TileVertex>> cities, List<Land> landTiles){
        this.graph = graph;
        this.cities = cities;
        this.centralHub = null;
        this.cityCentroids = new ArrayList<>();
        this.pathEdges = new ArrayList<>();
        this.nodePath = new ArrayList<>();
        this.networkArea = landTiles;
    }

    public void createNetwork(){
        for(Node<TileVertex> city: cities){
            if(city.getPropertyValue("City Type").equals(CityType.CAPITAL)){
                centralHub = city; // extract the capital city from the list of cities
            }
        }
        cities.remove(centralHub);

        for(Node<TileVertex> city: cities){
            ShortestPath<TileVertex> path = new ShortestPath<>();
            nodePath = path.findPath(graph, centralHub, city);

            if(nodePath != null){
                for(Node<TileVertex> node: nodePath){ // get the centroids that make up the shortest path
                    cityCentroids.add(node.getId());
                }
            }
            System.out.println(nodePath);
        }

//        List<Edge<TileVertex>> potentialPathEdges;
//        for(Node<TileVertex> node: nodePath){ // get the edges that make up the shortest paths between capital city and other cities
//            potentialPathEdges = graph.getConnectedEdges(node);
//            for(Edge<TileVertex> edge: potentialPathEdges){
//                if(nodePath.contains(edge.getNode()) && !pathEdges.contains(edge)){
//                    pathEdges.add(edge);
//                }
//            }
//        }
        createPath(cityCentroids); // change the thickness of path edges
        createCities(cityCentroids); // change the thickness of city vertices
    }

    private void createPath(List<TileVertex> cityCentroids){
        List<TileSegment> neighbouringSegments;
        for(Land landTile: networkArea){
            Tile tile = landTile.getTile();
            neighbouringSegments = tile.getNeighbouringTileSegments();
            for(TileSegment neighbouringSegment: neighbouringSegments){
                if(cityCentroids.contains(neighbouringSegment.getTileVertex1()) && cityCentroids.contains(neighbouringSegment.getTileVertex2())){
                    neighbouringSegment.setThickness(25.0);
                }
            }
        }
    }

    private void createCities(List<TileVertex> cityCentroids){
        for(Land landTile: networkArea){
            Tile tile = landTile.getTile();
            TileVertex tileCentroid = tile.getCentroid();
            if(cityCentroids.contains(tileCentroid)){
                tileCentroid.setThickness(50.0);
            }
        }
    }

    public List<TileVertex> getCityCentroids(){
        return cityCentroids;
    }

    public List<Edge<TileVertex>> getPathEdges(){
        return pathEdges;
    }
}
