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
public class hw3_1 {
    static int n = 6;
    static int[][] col = new int[n][2];
    static int count = 0;
    public static void queens(int i){
        int j; 
        if(promising(i)){
            if(i==n-1){
               count++;
               System.out.println(Arrays.deepToString(col));
            }
            else{
                for(j = 0;j<n;j++){
                    for(int k = 0;k<n;k++){
                        col[i+1][0] = j;
                        col[i+1][1] = k;
                        queens(i+1);
                    }
                }
            }
        }
    }
    public static int getLength(){
        return count;
    }
    public static boolean promising(int i){
        int k = 0;
        boolean sw = true;
        while(k<i&&sw){
            if(col[i][0] == col[k][0] ||
                    col[i][1] == col[k][1]||
                    Math.abs(col[i][0] - col[k][0]) == Math.abs(col[i][1] - col[k][1])
                    ||Math.abs(col[i][0] - col[k][0]) == i-k||
                    Math.abs(col[i][1] - col[k][1]) == i-k)
                sw = false;
            k++;
        }
        return sw;
    }
    public static void main(String[] args) {
        queens(-1);
        System.out.println("when n is "+n + " the result is :");
        System.out.println(getLength());
    }
}
