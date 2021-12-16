//Anshul Chouhan
//0801IT191012

import java.util.*;

class Kth_max {
    static int[] heap;
    static int curr_size=1;
    static int n;

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        curr_size=1;
        build(n);
        for(int i=0;i<n;i++){
            int val=s.nextInt();
            insertKey(val);
        }
        int k=s.nextInt();
        if(k>n){
            System.out.println("-1");
            return;
        }
        for(int i=0;i<n-k+1;i++){
            Extract_Max();
        }
        System.out.println(Extract_Max());

        s.close();
    }

    static void swap(int i,int j){
        int val=heap[i];
        heap[i]=heap[j];
        heap[j]=val;
    }
    static void build(int n){
        heap=new int[n+1];
    }
    static int left(int i){
        return 2*i;
    }
    static int right(int i){
        return 2*i+1;
    }
    static int parent(int i){
        return i/2;
    }

    static void insertKey(int val){
        heap[curr_size]=val;
        int i=curr_size;
        curr_size++;
        while(i>1 && heap[parent(i)]<heap[i]){
            swap(i,parent(i));
            i=parent(i);
        }
    }

    static int Extract_Max(){
        if(curr_size==0)return -1;
        int ans= heap[0];
        heap[0]=heap[curr_size-1];
        curr_size--;
        swim(0);
        return ans;
    }
    private static void swim(int i) {
        int l=left(i);
        int r=right(i);
        int max=i;
        if(l < curr_size && heap[l]>heap[i]){
            max=l;
        }
        if(r<curr_size && heap[r]>heap[max]){
            max=r;
        }
        if(max!=i){
            swap(i,max);
            swim(max);
        }
    }
}
