/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amit
 * @param <E>
 */
public class WeightedEdge<E> implements Comparable <WeightedEdge>{
    int src_V;
    int des_V;
    double weight;
    E alpha;
    public WeightedEdge(int src, int des, double val){
        this.src_V = src;
        this.des_V = des;
        this.weight = val;
    }
    
    public WeightedEdge(int src, int des, E djd){
        this.src_V = src;
        this.des_V = des;
        this.alpha = djd;
    }
    public int from(){
        return this.src_V;
    }
    public int to(){
        return this.des_V;
    }
    public double cost(){
        return this.weight;
    }

    @Override
    public int compareTo(WeightedEdge that){
        if(this.weight < that.weight)
            return -1;
        else if(this.weight > that.weight)
            return 1;
        else
            return 0;
    }
    
    public WeightedEdge reverse(){
        WeightedEdge tmp = new WeightedEdge(this.des_V,this.src_V,this.weight);
        return tmp;
    }
}
