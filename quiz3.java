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
public class quiz3 {
    public static Map<Integer,Integer> bf(int[] nuts,int[] bolts){
        int n = nuts.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(nuts[i]==bolts[j])
                    map.put(i, j);
            }
        }
        return map;
    }
    public static Map<Integer,Integer> useMap(int[] nuts,int[] bolts){
        int n = nuts.length;
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nuts[i], i);
        }
        for(int i = 0;i<n;i++){
            res.put(map.get(bolts[i]), i); 
        }
        return res;
    } 
    public static void main(String[] args) {
        int[] nuts = {4,2,5,6,3,7};
        int[] bolts = {7,6,2,4,3,5};
        System.out.println("The corresponding nuts and bolts are:");
        System.out.println(bf(nuts, bolts));
        System.out.println(useMap(nuts, bolts));
    }
}
