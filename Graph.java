/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amit
 */
import java.util.*;
public class Graph {
    private int V;
    private int E = 0;
    private ArrayList<Integer>[] adjList ;
    
    public Graph(int V){
        this.V = V;
        //adjList = (ArrayList<Integer>[]) new ArrayList<?>[V];
        adjList = new ArrayList[V];
        for(int i = 0; i< V; i++){
            adjList[i] = new ArrayList<>();
        }
    }
    
    public ArrayList<Integer> neighbourList(int src){
        return adjList[src];
    }
    
    public void addEdge(int src, int tar){
        if(src < V){
            adjList[src].add(tar);
            E++;
        }
        else{
            System.out.println("Sorce Vertex not in Graph");
            return;
        }
    }
    
    public void removeEdge(int src, int tar){
        if(adjList[src].contains(tar)){
            adjList[src].remove(tar);
            E--;
        }
    }
    public int numVer(){
        return V;
    }
    public int numEdge(){
        return E;
    }
    
    //public void buildFromList(int src, )
    public void addFromList(int src, LinkedList<Integer> neighbour){
        adjList[src].addAll(neighbour);
        
    }
    public void addFromarray(int src, int [] array){
        
    }
    
    
    public int connected_comp(){
        boolean [] visited = new boolean[V];
        int connected_component = 0;
        for(int i = 0; i< V; i++){
            visited[i] = false;
        }
        for(int i = 0; i< V;i++){
            if(!visited[i]){
                connected_component++;
                System.out.print("Coonected componenct no :"+ connected_component+" are: ");
                dfs(i,visited);
                System.out.println("");
            }
        }
        return connected_component;   
    }
    
    /*
     * checks if there is a path between any 2 vertices in the graph
     * call dfs from source vertex and if there is a path between
     * source and target vertex , then visited[target] will be set true. 
     */
    public boolean hasDfsPath(int src, int target){
        boolean [] visited = new boolean[V];
        dfs(src,visited);
        return visited[target];
    }
    
    public void DFS(int src){
        boolean [] visited = new boolean[V];
        for(int i = 0; i< V ; i++){
            visited[i] = false;
        }
        dfs(src,visited);
    }
    private void dfs(int source,boolean [] visited){
        visited[source] = true;
       System.out.print(source +" ");
        for(Integer i: adjList[source]){
            if(!visited[i]){
                dfs(i,visited);
            }
        }
    }
    private ArrayList<Integer> dfsPath(int source, int target, boolean[] visited, ArrayList<Integer> path){
        visited[source] = true;
        if(source == target){
            path.add(source);
           // return path;
        }
        for(int i: adjList[source]){
            if(!visited[i]){
                path.add(i);
                path = dfsPath(i,target,visited,path);
            }
        }
        return path;
    }
    public void printDfsPath(int src, int tar){
        if(hasDfsPath(src,tar)){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(src);
            boolean [] visited = new boolean[V];
            for(int i = 0; i< V; i++){
                visited[i] = false;
            }
            path = dfsPath(src,tar,visited,path);
            Iterator <Integer> my = path.iterator();
            System.out.println("The path is");
            System.out.println("Hello ");
            while(my.hasNext()){
                System.out.print(my.next() +" ");
            }
            
        }
        else{
            System.out.println("Errr.... there are no path between given nodes");
            return ;
        }
        return;
    }
    public void BFS(int src){
        boolean [] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i< V; i++){
            visited[i] = false;
        }
        BFS(src,visited,queue);
    }
    private void BFS(int source, boolean [] visited, Queue<Integer> queue){
        
    }
    
  
}


