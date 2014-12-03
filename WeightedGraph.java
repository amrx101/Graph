/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amit
 */
//package Graphs;
import java.util.*;
public class WeightedGraph {
    int V;
    int E = 0;
    PriorityQueue<WeightedEdge> [] adjList;    
    // constructor
    public WeightedGraph(int numVertices){
        this.V = numVertices;
        adjList = (PriorityQueue<WeightedEdge>[])new PriorityQueue<?> [numVertices];
        for(int i = 0; i< V; i++){
            adjList[i] = new PriorityQueue<>();
        }
       // adjList = new PriorityQueue[V];
    }
    public  void addEdge(int src, int des, double val){
        WeightedEdge edge = new WeightedEdge(src,des,val);
        addEdge(edge);
    }
    
    private void addEdge(WeightedEdge edge){
        adjList[edge.src_V].offer(edge);
        adjList[edge.des_V].offer(edge.reverse());
    }
    public PriorityQueue<WeightedEdge> getNeighbours(int src){
        return adjList[src];
    }
    
    public void printNeighbours (int src){
        PriorityQueue<WeightedEdge> tmp = getNeighbours(src);
        System.out.print("The neighbours of vertex i are : ");
        for(WeightedEdge e: tmp){
            System.out.print(" "+e.des_V+ " with cost "+e.weight+ " ");
        }
    }
    
    public void printGraph(){
        for(int i = 0; i< V; i++){
            PriorityQueue<WeightedEdge> tmp = getNeighbours(i);
           // Iterator<PriorityQueue<WeightedEdge> in = tmp.iterator();
            System.out.print("Edges from vertex "+ i+" are  :");
            for(WeightedEdge e: tmp){
                System.out.print(" to destination "+e.des_V+" cost "+e.weight);
            }
            System.out.println("");
            
        }
    }
    
}

