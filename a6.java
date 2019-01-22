/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.io.IOException;
import java.util.Scanner;

class List {
//    private static int max = Integer.MAX_VALUE;
    // 邻接表中表对应的链表的顶点
    private class ENode {
        int ver;       // 该边所指向的顶点的位置
        ENode next; // 指向下一条弧的指针
    }
    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };

    private VNode[] mVexs;  // 顶点数组
    
    private class EData {
        char start; // 边的起点
        char end;   // 边的终点

        public EData(char start, char end) {
            this.start = start;
            this.end = end;
        }
    };
    
    char[] vexs = {'A', 'B', 'C','D'};
    EData[] edges = {
               // 起点 终点 权
        new EData('A', 'B'), 
        new EData('A', 'C'), 
        new EData('A', 'D'), 
        new EData('B', 'C'), 
        new EData('B', 'D'), 
    };
    
    public List() {
        
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        // 初始化"边"
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            char c1 = edges[i].start;
            char c2 = edges[i].end;

            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ver = p2;
//            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
              mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ver = p1;
//            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
              mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }
     private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.next!=null)
            p = p.next;
        p.next = node;
    }

     private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }
    public VNode[] getList(){
        return mVexs;
    }
private void DFS(int i, boolean[] visited) {
        ENode node;
        
        visited[i] = true;
//        System.out.printf("%c ", mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node != null) {
            if (!visited[node.ver])
                DFS(node.ver, visited);
            node = node.next;
        }
    }
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // 顶点访问标记

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;
        int count = 0;
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]){
                DFS(i, visited);
                count++;
            }
                DFS(i, visited);
        }
        if(count == 1)
        {
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }
}  
public class a6 {
    public static void main(String[] args) {
        List l = new List();
        l.DFS();
    }
}
