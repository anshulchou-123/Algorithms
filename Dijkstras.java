import java.io.*;
import java.lang.*;
import java.util.*;

class node{
    int v,w;
    public node(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class comparator implements Comparator<node>{
    public int compare(node a,node b){
        return a.w-b.w;
    }
}
public class Dijkstras {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int[] dis=new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        List<List<node>> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i,new ArrayList<>());
        }
        int m=s.nextInt();
        for(int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            int w=s.nextInt();
            arr.get(a).add(new node(b,w));
            arr.get(b).add(new node(a,w));
        }
        dis[k]=0;
        TreeSet<node> set=new TreeSet<>(new comparator());
        boolean[] included=new boolean[n];
        set.add(new node(k,0));
        for(int i=0;i<n;i++){
            if(i==k)continue;
            set.add(new node(i,Integer.MAX_VALUE));
        }
        while(!set.isEmpty()){
            node e=set.pollFirst();
            included[e.v]=true;
            for(node neighbour:arr.get(e.v)){
                if(included[neighbour.v])continue;
                if(dis[neighbour.v]==Integer.MAX_VALUE || dis[neighbour.v]>dis[e.v]+neighbour.w){
                    set.remove(new node(neighbour.v,dis[neighbour.v]));
                    dis[neighbour.v]=dis[e.v]+neighbour.w;
                    set.add(new node(neighbour.v,dis[neighbour.v]));
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dis[i]+" ");
        }
    }
}
