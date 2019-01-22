/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
/**
 *
 * @author pittsfirstbeauty
 */
class conGraph1{
    private int num;
    private int[][] dimArray;
    private int m;
    public conGraph1(int n){
        num = n;
        dimArray = new int[num][num];
        m = (num*(num-1))/2;
    }
    public int[] generateRandom(){
        int[] res = new int[2];
        int temp = random(0,num-1);//横可以填除第一格
        int temp1 = random(0,num-1);//竖着填除最后一格
        if(temp == temp1){
            return generateRandom();
        }
        else{
            res[0] = temp;
            res[1] = temp1;
            return res;
        }
    }
    public int random(int s,int e){
        int rand = s + (int)(Math.random() * (e-1+1));
        return rand;
    }
    public int connect(){
        return 1;
    }
    public int[][] ConnectGraph(){
        Set<Integer> set = new HashSet<>();
        int[] firstPosition = generateRandom();
        int temp = firstPosition[0];
        int temp1 = firstPosition[1];
        int s = connect();
        dimArray[temp][temp1] = s;
        dimArray[temp1][temp] = s;
        set.add(temp);
        set.add(temp1);
        while(set.size() < num){
            int y = 0;
            Object[] setArray = set.toArray();
            int tempx  = random(0, setArray.length);
            int x = (int)setArray[tempx];
            for(int i = 0;i<num;i++){
                if(!set.contains(i)){
                    y = i;
                    break;
                }
            }
            int r = connect();
            dimArray[x][y] = r;
            dimArray[y][x] = r;
            set.add(y);
        }
        int r = random(0,m-set.size());
        while(r>0){
            int i = random(0,num-1);
            int j = random(0,num-1);
            if(dimArray[i][j]==0&&i!=j){
                dimArray[i][j] = 1;
                dimArray[j][i] = 1;
                r--;
            }
        }
        return dimArray;
    }
}
class solution1{
    private int[][] dimArray;
    private int num;
    private ArrayList<Integer> al;
    private ArrayList<Integer> res;
    private int m;
    public solution1(int[][] n){
        dimArray = n;
        num = dimArray.length;
        res = new ArrayList<Integer>();
        al = new ArrayList<Integer>();
    }
    public ArrayList<Integer> IndepSet(){
        int s = -1;
        prob1(s);
        return res;
    }
    public void prob1(int i){
//        System.out.println(i);
//        System.out.println(promising(0));
        if(promising(i)){
            if(al.size()>res.size()){
                res = new ArrayList<Integer>();
                for(int x : al)
                    res.add(x);
            }
            for(int x = i+1;x<num;x++){
                al.add(x);
                prob1(x);
                al.remove(al.size()-1);
            }
        }
    }
    public boolean promising(int i){
        int k = 0;
        boolean sw = true;
        int l = al.size();
        while(k<l&&sw){
            if(dimArray[al.get(k)][i]==1){
                sw = false;
            }
            k++;
        }
        return sw;
    }
}
public class t {
    public static void main(String[] args) {
        conGraph1 cg = new conGraph1(7);
        int[][] c = cg.ConnectGraph();
        System.out.println(Arrays.deepToString(c));
        solution1 s = new solution1(c);
        ArrayList<Integer> res1 = s.IndepSet();
        System.out.println(res1.toString());
    }
}

