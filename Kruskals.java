
import java.io.*;
import java.lang.*;
import java.util.*;

class Edge {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class comparator implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
        return a.w - b.w;
    }
}

public class Kruskals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] parent = new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        int[] rank = new int[n];
        int m = s.nextInt();
        TreeSet<Edge> min_heap = new TreeSet<>(new comparator());
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int w = s.nextInt();
            min_heap.add(new Edge(a, b, w));
        }
        int count = 0;
        long ans=0;
        while (count < n-1) {
            Edge e = min_heap.pollFirst();
            int x=find(e.u,parent);
            int y=find(e.v,parent);
            if(x==y)continue;
            System.out.println(e.u+" "+e.v+" "+e.w);
            ans+=e.w;
            Union(parent, rank, x, y);
            count++;
        }
        System.out.println(ans);

    }
    static void Union(int[] parent,int[] rank,int i,int j){
        int x=find(i,parent);
        int y=find(j,parent);
        if(rank[x]<rank[y]){
            parent[x]=y;
        }else if(rank[x]>rank[y]){
            parent[y]=x;
        }else{
            parent[x]=y;
            rank[y]++;
        }
    }
    static int find(int i,int[] parent){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i], parent);
    }
}
