/*

Given a directed graph write an algo for that preints topological ordering of the graph.
In topological order, for a given edge from a->b the node a should come before node b, and this should be true for all the edges in the graph.
So, any node with zero indegree can be printed first.
Kahn's Algo:
   ->create a directed graph with given edges
   ->create a varriable count which will store number of nodes processed in topological order
   ->Store all node with zero indegree in a queue
   ->Take a node from queue and decrease indegree of all neighbouring node by 1, and if any node'sindegree gets 0 store it in the queue
   ->If the queue is not empty repeat step 1 and 2
   ->At end if count  value if not equal to n it means there is a cycle in the graph.

*/

import java.util.*;
import java.lang.*;
import java.io.*;
public class Kahns {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<=n;i++)arr.add(i,new ArrayList<>());
        int m=s.nextInt();
        int[] in=new int[n+1];
        for(int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            arr.get(a).add(b);//edge from node a to b
            in[b]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(in[i]==0)q.add(i);
        }
        List<Integer> list=new ArrayList<>();//act as count varialble and also storess toplogical order 
        while(!q.isEmpty()){
            int i=q.poll();
            list.add(i);
            for(int neighbour:arr.get(i)){
                in[neighbour]--;
                if(in[neighbour]==0)q.add(neighbour);
            }
        }
        if(list.size()!=n){
            System.out.println("Graph contains Cycle");
        }else {
            for(int i=0;i<n;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println("");
        }

    }
}
