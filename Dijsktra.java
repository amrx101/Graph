/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amit. 
 */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
public class Dijsktra {
    
    private WeightedGraph myGraph;
    private int V;
     int [] parent;
     double [] distance;
    private boolean [] visited;
    
    
    
    public Dijsktra(WeightedGraph graph){
        this.myGraph = graph;
        this.V = graph.V;
        parent = new int [this.V];
        distance = new double [this.V];
        visited = new boolean[V];
    }
    
    public void initialize(int src){
        for(int i = 0; i < V; i++){
            if(i != src){
                distance[i] = Double.POSITIVE_INFINITY;
                visited[i] = false;
                parent[i] = -1;
            }
        }
        distance[src] = 0;
        parent[src] = src;
        visited[src] = false;
    }
    public boolean hasPath(int src, int destination){
        shortestDistance(src);
        boolean val = false;
        if(distance[destination]!= Double.POSITIVE_INFINITY)
            val = true;
        return val;
    }
    public Stack computePath(int src, int destination){
        if(!hasPath(src,destination)){
            System.out.println("noPath between specified vertices");
            return null;
        }
        Stack<Integer> myStack = new Stack<>();
        while( destination != src){
            myStack.add(destination);
            destination = parent[destination];
        }
        return myStack;
    }
    public void printPath(int src, int destination){
        Stack <Integer> myStack = computePath(src,destination);
        System.out.print("The path between vertices "+src +" and "+ destination+ "is : "+ src+" ");
        while(!myStack.empty()){
            System.out.print(myStack.pop()+" ");
        }
    }
    
    public void shortestDistance(int src){
        initialize(src);
        Vertex tmp = new Vertex(src,distance[src]);
        PriorityQueue<Vertex> minPQ = new PriorityQueue<>();
        minPQ.offer(tmp);
        while(!minPQ.isEmpty()){
            Vertex from = minPQ.poll();
            int x = from.vertexNumber;
            if(visited[x]) continue;
            for(WeightedEdge edge: myGraph.getNeighbours(x)){
                int y = edge.to();
                if(distance[y] > distance[x]+edge.weight){
                    distance[y] = distance[x]+edge.weight;
                    parent[y] = x;
                    minPQ.offer(new Vertex(y,distance[y]));
                }
            }
        }
    }
    
    private class Vertex implements Comparable<Vertex>{
        int vertexNumber;
        double distance;
        public Vertex(int x, double y){
            this.vertexNumber = x;
            this.distance = y;
        }
        

        @Override
        public int compareTo(Vertex that) {
            if(this.distance > that.distance){
                return 1;
            }
            else if(this.distance < that.distance){
                return -1;
            }
            else{
                return 0;
            }
            
        }
    }
    
    
    
}

