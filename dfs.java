package test;

import java.io.*; 
import java.util.*; 
import java.util.Stack;
class Node1{
    int ver;
    Node1 next;
    public Node1(int ver,Node1 next){
        this.ver=ver;
        this.next=next;
    }
}
class Graph{
    public int size;   
    public Node1[] adj;
    Graph(int v) { 
        size = v; 
        adj = new Node1[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new Node1(i,null); 
        } 
	  
    void addEdge(int v,int w) {
        if(adj[v].next==null&&adj[w].next==null) {
            adj[v].next=new Node1(w,null);
            adj[w].next=new Node1(v,null);
        }
        else if(adj[v].next==null&&adj[w].next!=null) {
            adj[v].next=new Node1(w,null);
            Node1 key1=adj[w];
            while(key1!=null) {
                if(key1.next==null)
                    break;
                key1=key1.next;
            }
            key1.next=new Node1(v,null);
        }
        else if(adj[v].next!=null&&adj[w].next==null) {
            adj[w].next=new Node1(v,null);
            Node1 key=adj[v];
            while(key!=null) {
                if(key.next==null)
                    break;
                key=key.next;
            }
            key.next=new Node1(w,null);
        }
        else {
            Node1 key=adj[v];
            Node1 key1=adj[w];
            while(key!=null) {
                if(key.next==null)
                    break;
                key=key.next;
            }
            while(key1!=null) {
                if(key1.next==null)
                        break;
                key1=key1.next;
            }
            key.next=new Node1(w,null);
            key1.next=new Node1(v,null);
        }		
    }
}
   
class Main { 
    public static boolean DFSifconnected(Node1[] graph) {
        Stack<Integer> S=new Stack<>();
        HashSet<Integer> h=new HashSet<>();
        int result[]=new int[graph.length];
        S.push(graph[0].ver);
        h.add(graph[0].ver);
        while(!S.isEmpty()) {
            int i=S.pop();
            result[i]=i;
            Node1 key=graph[i];
            while(key.next!=null) {
                if(!h.contains(key.next.ver)) {
                    h.add(key.next.ver);
                    S.push(key.next.ver);
                }
                key=key.next;
            }
        }
        for(int i=0;i<result.length;i++) {
            if(result[i]!=i)
                return false;
            else
                continue;
        }
        return true;
    }
	
    public static void main(String args[]) { 
    	List<Integer> q=new LinkedList<>();
        Graph g1 = new Graph(5); 	        
        g1.addEdge(0, 1); 
	    g1.addEdge(1, 2); 
	    g1.addEdge(2, 3); 
	    g1.addEdge(3, 0); 
        for(int i=0;i<g1.adj.length;i++) {
            Node1 key=g1.adj[i];
            while(key!=null) {
                System.out.print(key.ver+" ");
                key=key.next;
            }
            System.out.print('\n');
        }
        if (DFSifconnected(g1.adj)) 
            System.out.println("Connected"); 
        else
            System.out.println("Not Connected");
        Graph g2 = new Graph(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3);
        for(int i=0;i<g2.adj.length;i++) {
            Node1 key=g2.adj[i];
            while(key!=null) {
                System.out.print(key.ver+" ");
                key=key.next;
            }
            System.out.print('\n');
        }
        if (DFSifconnected(g2.adj)) 
            System.out.println("Connected"); 
        else
            System.out.println("Not Connected");
    }
}
 

