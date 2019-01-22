/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
public class a10 {
    public static int[] commonArray(int[] s, int[] t){
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<s.length;i++){
            if(!map.containsKey(s[i]))
                map.put(s[i], 1);
            else
                map.put(s[i],map.get(s[i])+1);
        }
        for(int i = 0;i<t.length;i++){
            if(map.containsKey(t[i])&&map.get(t[i])>=0){
                al.add(t[i]);
                map.put(t[i],map.get(t[i])-1);
            }
        }
        int[] res = new int[al.size()];
        int i = 0;
        for(int a: al){
            res[i++] = a;
        }
        return res;
    }
    public static void main(String[] args) {
        //test1:
        int[] s =  {1, 5, 3, 2, 9};
        int[] t = {7, 8, 10, 5, 3, 1, 9};
        int[] r = commonArray(s, t);
        System.out.println(Arrays.toString(r));
        //test2:
        int[] s2 =  {1, 3, 5, 7, 9, 13, 16};
        int[] t2 = {2, 3, 6, 8, 10};
        int[] r2 = commonArray(s2, t2);
        System.out.println(Arrays.toString(r2));
        //test3:
        int[] s3 = {1, 1, 1, 1, 1};
        int[] t3 = {1, 1, 1, 1, 1};
        int[] r3 = commonArray(s3, t3);
        System.out.println(Arrays.toString(r3));
        //test4:
        int[] s4 = {1, 2, 3, 4, 5};
        int[] t4 = {6, 7, 8, 9};
        int[] r4 = commonArray(s4, t4);
        System.out.println(Arrays.toString(r4));
    }
}
