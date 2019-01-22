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
public class c9 {
    static int maxsqlen;
    static int maxsq;
    static int[] res = new int[2];
    public static void maxSquare(int[][] matrix){
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], 
                            dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    if(maxsqlen<dp[i][j]){
                        res[0] = i - 2;
                        res[1] = j-2;
                        maxsqlen = dp[i][j];
                    }
                }
            }
        }
        maxsq = maxsqlen*maxsqlen;
    } 
    public static int maxWidth(){
        return maxsqlen;
    }
    public static int maxArea(){
        return maxsq;
    }
    public static int[] getEle(){
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        System.out.println("The orginal matrix looks like: ");
        for(int i = 0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        maxSquare(matrix);
        System.out.println("The biggest width of square is: ");
        System.out.println(maxWidth());
        System.out.println("The top left corner of such a square is: ");
        System.out.println(Arrays.toString(getEle()));
    }
    
}
