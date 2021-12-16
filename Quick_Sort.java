import java.util.*;
import java.lang.*;
import java.io.*;
class Quick_Sort{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        a[n]=Integer.MAX_VALUE;//see comments for reason
        quick_sort(a,0,n);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
    static void quick_sort(int[] a,int l,int r){//sort range l to r
            if(r<=l)return ;
            int index=find_index(a,l,r);//places first element at its current position and all element less then to at itss left and greater then it to right
            System.out.println(index);
            for(int i=0;i<a.length;i++){//checking the elements after a call
                System.out.print(a[i]+" ");
            }
            System.out.println("");
            quick_sort(a, l, index-1);
            quick_sort(a, index+1, r);
    }
    static int find_index(int[] a,int l,int r){//fix first element as pivot and find its position in sorted array and put it there
        int pivot=a[l];
        int left=l;
        while(l<r){
            while(a[l]<=pivot)l++;//find an element strictly greater then pivot and there is no possibility of out of bound because we have added infinity at last of the array
            while(a[r]>pivot)r--;//find an element less then equal to pivot and if no element found it will stop at the pivot element so no index out of bound possibility
            if(l<=r){
                swap(a,l,r);//if two elements are there it swap them 
            }
        }
        swap(a,left,r);//" r" is the position where pivot element should be present so it places it at "r"
        return r;//"r" represents element at "r" is at its correct position now sort left and right half recursively by placing elements at its correct position
    }
    static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}