/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Arrays;

/**
 *
 * @author pittsfirstbeauty
 */

public class hw3_2 {
    static int[][] graph = {{0, 0, 0, 10, 0, 2, 3, 0, 1, 0},
        {0, 0, 10, 5, 6, 1, 3, 5, 5, 0},
        {0, 10, 0, 10, 7, 9, 1, 7, 0, 4},
        {10, 5, 10, 0, 10, 9, 9, 1, 8, 5},
        {0, 6, 7, 10, 0, 2, 6, 1, 6, 8},
        {2, 1, 9, 9, 2, 0, 10, 8, 2, 7},
        {3, 3, 1, 9, 6, 10, 0, 5, 7, 1},
        {0, 5, 7, 1, 1, 8, 5, 0, 2, 3},
        {1, 5, 0, 8, 6, 2, 7, 2, 0, 2},
        {0, 0, 4, 5, 8, 7, 1, 3, 2, 0}};
    static int n = graph.length;
    static int[] vindex = new int[n];
    static int count;
    static int m = Integer.MAX_VALUE;
    static int[] res;
    public static void hamiltonian(int i,int weight){
        int j;
        if(promising(i,weight)){
            if(i==n-1){
                count++;
                weight += graph[vindex[i]][0];
                if(weight<m){
                    m = weight;
                    res = Arrays.copyOf(vindex, n);
                }
            }
            else{
                for(j = 1;j<n;j++){
                    vindex[i+1] = j;
                    hamiltonian(i+1,weight + graph[vindex[i]][j]);
                }
            }
        }
    }
    public static boolean promising(int i,int weight){
        int j;
        boolean sw;
        if(i==n-1 && graph[vindex[n-1]][vindex[0]]==0)
            sw = false;
        else if(i>0&& graph[vindex[i-1]][vindex[i]]==0)
            sw = false;
        else{
            sw = true;
            j = 0;
            while(j<i && sw){
                if(vindex[i] == vindex[j])
                    sw = false;
                j++;
            }
        }
        if(weight>m)
            sw = false;
        return sw;
    }
    public static int getMinResult(){
        System.out.println(Arrays.toString(res));
        return m;
    }
    public static void main(String[] args) {
        hamiltonian(0,0);
        Runtime rt=Runtime.getRuntime( );     
         System.out.println("Total Memory= " + rt.totalMemory()+ 
                 " Free Memory = "+rt.freeMemory()+" Used　Memory="
                 +(rt.totalMemory()-rt.freeMemory())); 
//        System.out.println(getMinResult());
    }
}
