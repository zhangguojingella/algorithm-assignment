/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author pittsfirstbeauty
 */
public class a4_1 {
    public static void main(String[] args) {
        int[] inputs = {49,41,34,33,29,26,26,22,20,19};
        int w = 100;
        int l = inputs.length;
        ArrayList<Integer> al = new ArrayList<>();
        int res = 0;
        for(int i = 0;i<l;i++){
            if(al.isEmpty()){
                al.add(inputs[i]);
                res++;
            }
            else{
//                Collections.sort(al);
                boolean packed = false;
                for(int j = 0;j<al.size();j++){
                    if(al.get(j)+inputs[i]<=100){
                        al.add(inputs[i]+al.get(j));
                        al.remove(j);
                        packed = true;
                        break;
                    }
                }
                if(packed == false){
                    al.add(inputs[i]);
                    res++;
                }
            }
        }
        System.out.println(res);
        System.out.println(al);
    }
}
