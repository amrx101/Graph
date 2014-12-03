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
public class TestGraph {
    public static void main(String[] args) {
        Graph myGraph = new Graph(7);
        LinkedList <Integer> myLink = new LinkedList<>();
        myLink.add(1);
        myLink.add(2);
        myGraph.addFromList(0, myLink);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(2, 1);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(5,6);
      /*  System.out.println(myGraph.neighbourList(0));
        System.out.println(myGraph.neighbourList(1));
        System.out.println(myGraph.neighbourList(2));
        myGraph.DFS(0);
        System.out.println("");
        myGraph.DFS(2);
        System.out.println("");*/
        int connected_component = 0;
        connected_component = myGraph.connected_comp();
        System.out.println ("Total connected component are :"+ connected_component);/*
        System.out.println("Is path between 0 and 6, should print false....."+ myGraph.hasDfsPath(0, 6));
        System.out.println("Is pathe between 0 and 2, should print true....."+ myGraph.hasDfsPath(0,2));*/
       // myGraph.printDfsPath(0, 6);
        myGraph.printDfsPath(0,4);
        // TO DO DFS , BFS, CONNECTED Componenets , DFS PATH
    }
    
}
