/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.util.*;
/**
 *
 * @author pittsfirstbeauty
 */
class knap{
    int[] p = new int[]{20,30,35,12,3};
    int[] w = new int[]{2,5,7,3,1};
    int W = 9;
    int MaxProfit = Integer.MIN_VALUE;
    boolean[] include = new boolean[p.length] ;
    boolean[] bestset = new boolean[p.length] ;
    int weight = 0;
    int profit; 
    int n = 5;
    public void knapsack(int i,int profit, int weight){
        this.profit = profit;
        
        if(weight <= W && profit > MaxProfit){
            MaxProfit = profit;
            bestset = include.clone();
        }
        if(promising(i, weight)){
            include[i+1] = true;
            knapsack(i+1,profit+p[i+1],weight+w[i+1]);
            include[i+1] = false;
            knapsack(i+1, profit, weight);
        }
    }
    public boolean promising(int i, int weight){
        int j, k = 0;
        int totweight = 0;
        float bound;
        if(weight>=W||i==p.length-1)
            return false;
        else{
            j = i + 1;
            bound = profit;
            totweight = weight;
            while(j < n && totweight + w[j] <= W){
                totweight = totweight + w[j];
                bound = bound + p[j];
                j++;
            }
            k = j;
            if(k < n)
                bound = bound + (W-totweight)*p[k]/w[k];
            return bound > MaxProfit;
        }
    }
}
public class a7 {
    public static void main(String[] args) {
        knap k = new knap();
//        System.out.println("1");
        k.knapsack(-1, 0, 0);
        System.out.println(k.MaxProfit);
        System.out.println(Arrays.toString(k.bestset));
    }
}
