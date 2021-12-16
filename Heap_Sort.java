import java.lang.*;
import java.io.*;
import java.util.*;

class Heap_Sort {
    static int[] heap;
    static int curr_size=0;
    static int n;

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        curr_size=0;
        build(n);
        for(int i=0;i<n;i++){
            int val=s.nextInt();
            insertKey(val);
        }
        for(int i=0;i<curr_size;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println("");
        heap_sort(n, curr_size);
        for(int i=0;i<n;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println("");

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
        return 2*i+1;
    }
    static int right(int i){
        return 2*i+2;
    }
    static int parent(int i){
        return (i-1)/2;
    }

    static void insertKey(int val){
        heap[curr_size]=val;
        int i=curr_size;
        curr_size++;
        while(i>0 && heap[parent(i)]<heap[i]){
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

/* 
InsertKey:(Insert a key in the heap)
    First we add the element at the end of the heap. Now if it is greater then its parent then we swap it with its  parent.Now we check again and again until a heap is formed.

Swim: (heapify) Makes a heap from current elment if its childrens are already heapified
    Swin Operation takes the index 0 and then find its correct possition in the heap. The parent first finds the maximum among its children and swap itself with the max if max is greater then parent. Then recursively apply swin operation on that max children.

ExtractMax:(removes the maximum element)
    It first takes the max element which is at the top(index 0). Then to again make heap it apply swin operation on the top element , so to be ablee to apply swin operation on top element we just add the last element at the to and apply swin operation.

Structure :
    Array 43,34,23,20,19,15,16
           0  1  2  3  4  5  6
        
        Represents heap:
                        43
                     / (0)  \
                  34        23
                / (1) \    /(2)\
               20     19 15     16
              (3)    (4) (5)    (6)

    Advantages:
        ->Parent of an element at index i is at index (i-1)/2 if array used 0 based indexing, and in 1 based indexing parent is i/2
        ->Childrens of an element at index i is 2*i+1 and 2*i+2 if array used 0 based indexing, and in 1 based indexing childrens are at index 2*i and 2*i+1

Example :
    elements: 1 5 43 2 6
    Add 1:InsertKey(1)
                1
    Add 5:InsertKey(5)
                1
               /
              5
            It voilates heap popert so swap it with its parent
                5
               /
              1
    Add 43:InsertKey(43)
                5
               / \
              1   43
            It voilates heap popert so swap it with its parent
                43
               / \
              1   5 
    Add 2:InsertKey(2)
                43
               / \
              1   5 
             /
            2
            It voilates heap popert so swap it with its parent
                43
               / \
              2   5 
             /
            1
    Add 6:InsertKey(6)
                43
               / \
              1   5 
             / \
            2   6
            It voilates heap popert so swap it with its parent
                43
               / \
              6   5 
             / \
            2   1
    
    Heap formed:
                43
               / \
              1   5 
             / \
            2   6
    
    -> 43 1 5 2 6 
        0 1 2 3 4
*/