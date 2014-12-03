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

public class TestWeightedGraph {

    public static void main(String[] args) {
        WeightedGraph myWg = new WeightedGraph(7);
        myWg.addEdge(0, 1, 8);
        myWg.addEdge(0, 2, 5);
        myWg.addEdge(0, 5, 12);
        myWg.addEdge(0, 6, 7);
        myWg.addEdge(1, 2, 6);
        myWg.addEdge(1, 3, 10);
        myWg.addEdge(1, 6, 7);
        myWg.addEdge(3, 4, 8);
        myWg.addEdge(3, 5, 10);
        myWg.addEdge(3, 6, 5);
        myWg.addEdge(4, 5, 8);
        myWg.addEdge(5, 6, 7);
        //myWg.printGraph();
        Dijsktra my = new Dijsktra(myWg);
        my.printPath(1, 4);
        System.out.println("");
        int[] ass = my.parent;
        for (int i = 0; i < ass.length; i++) {
            System.out.print(ass[i] + " ");
        }
        System.out.println("");
        double [] dis = my.distance;
        for(int i = 0; i< dis.length; i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println("");

        // Lets Do Dijsktra Now , followed by Kruskal and Prim
    }

}
