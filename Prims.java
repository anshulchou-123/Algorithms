/*
Problem Statement: FInd minimum spanning tree of a connnected undirected graph
Prims algo maintains two set, first set contains all node which are included in the MST formed so far and the other set is not included in MST. It greedily selects an edge with min value which connects node from included set to non included set in MST.We can do this by starting the bfs from any node and keep selecting min edge value which connects two set.Time complextiy O((E+V)*logV) (E+V) for bfs and logV for selecting min edge .
Algo:
->Consider any node to start processing and give it a key value of 0 and add it in priority queue
->Key doing below step until all nodes are included in the MST
  -> Take the node with min key value
  ->Update all neighbours of the node if their key value is greater then edge weight.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class node{
    int v,w;
    public node(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class prims_node{
    int i;
    int min_edge;
    public prims_node(int i,int min_edge){
        this.i=i;
        this.min_edge=min_edge;
    }
}
class comparator implements Comparator<prims_node>{
    public int compare(prims_node a,prims_node b){
        return a.min_edge-b.min_edge;
    }
}

public class Prims {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        List<List<node>> arr=new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(i,new ArrayList<node>());
        }
        int m=s.nextInt();
        for(int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            int w=s.nextInt();
            arr.get(a).add(new node(b,w));
            arr.get(b).add(new node(a,w));
        }
        TreeSet<prims_node> priority_queue=new TreeSet<>(new comparator());
        priority_queue.add(new prims_node(0,0));
        boolean[] included=new boolean[n+1];
        int[] dis=new int[n+1];
        dis[0]=0;
        long ans=0;
        for(int i=1;i<n;i++){
            priority_queue.add(new prims_node(i,Integer.MAX_VALUE));
            dis[i]=Integer.MAX_VALUE;
        }
        while(!priority_queue.isEmpty()){
            prims_node top=priority_queue.pollFirst();
            included[top.i]=true;
            ans+=top.min_edge;
            for(node neighbour:arr.get(top.i)){
                if(!included[neighbour.v]){
                    if(dis[neighbour.v]>neighbour.w){
                        priority_queue.remove(new prims_node(neighbour.v, dis[neighbour.v]));
                        dis[neighbour.v]=neighbour.w;
                        priority_queue.add(new prims_node(neighbour.v, dis[neighbour.v]));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
