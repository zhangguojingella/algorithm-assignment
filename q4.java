/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;

/**
 *
 * @author pittsfirstbeauty
 */
public class q4 {
    public static void main(String []args){
        int[] oringal = {3, 6, 4, 1, 3, 4, 1, 4};
        int[] sorted = countSort(oringal);
        System.out.println(Arrays.toString(sorted));
    }
    public static int[] countSort(int[] a){
        int b[] = new int[a.length];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i : a){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        int k = max - min + 1;
        int c[] = new int[k];
        for(int i = 0; i < a.length; i++){
            c[a[i]-min] += 1;
        }
//        System.out.println(Arrays.toString(c));
        for(int i = 1; i < c.length; i++){
            c[i] = c[i] + c[i-1];
        }
//        System.out.println(Arrays.toString(c));
        int[] t = new int[a.length];
        int j = 0;
        for(int i =0;i<a.length;i++){
            t[j++] = c[a[i]-min]-1;
            c[a[i]-min]--;
        }
        System.out.println(Arrays.toString(t));
        for(int i = 0; i<a.length; i++){
            b[t[i]] = a[i];
        }
        return b;
    }
}

