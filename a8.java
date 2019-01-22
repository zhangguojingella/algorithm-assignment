/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;  
class node{
    public int level;
    public int profit;
    public int weight;
    public float bound;
}
class knap1{
    int[] p = new int[]{20,30,35,12,3};
    int[] w = new int[]{2,5,7,3,1};
    int W = 13;
    int maxProfit = 0;
    int n = 4;
    public void knapsack(){
        Queue<node> pq = new PriorityQueue<>(new Comparator<node>(){
            @Override
            public int compare(node n1, node n2) {
                return (n1.bound > n2.bound)?-1:1;
            }
        });
        
        node v = new node();
        v.level = -1;
        v.profit = 0;
        v.weight = 0;
        maxProfit = 0;
        v.bound = bound(v);
        pq.add(v);
        while(!pq.isEmpty()){
//            pq.remove(v);
            node x = pq.poll();
            if(v.bound>maxProfit){
                node u = new node();
                u.level = x.level + 1;
                u.weight = x.weight + w[u.level];
                u.profit = x.profit + p[u.level];

                if(u.weight <= W&&u.profit > maxProfit)
                    maxProfit = u.profit;
                u.bound = bound(u);
                if(u.bound > maxProfit)
                    pq.add(u);
                node u1 = new node();
                u1.level = x.level+1;
                u1.weight = x.weight;
                u1.profit = x.profit;
                u1.bound = bound(u1);
                if(u1.bound > maxProfit)
                    pq.add(u1);
            }
        }
    }
    public float bound(node u){
        int j,k;
        int totweight;
        float result;
        if(u.weight >= W)
            return 0;
        else{
            result = u.profit;
            j = u.level+1;
            totweight = u.weight;
            while(j<=n&&totweight+w[j]<=W){
                totweight = totweight + w[j];
                result = result + p[j];
                j++;
            }
            k = j;
            if(k<=n)
                result = result +(W-totweight) * p[k]/w[k];
            return result;
        }
    }
}
public class a8 {
    public static void main(String[] args) {
        knap1 k = new knap1();
        k.knapsack();
        System.out.println(k.maxProfit);
    }
}
