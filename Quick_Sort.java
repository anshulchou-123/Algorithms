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
            int index=find_index(a,l,r);//places first element at its current position and all element less then to at its left and greater then it to right
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
/*
Best case time complexity of this algorithm is O(nlogn) when the first element is the median of the range l to r
                    sort(l, l+1,.....,r)  ->O(n)
               first pivot should be present at n/2
            sort(l, .... n/2)   sort(n/2+1,...,n-1) O(n)
                                  n
                         /               \
                      1-n/2              n/2+1-n
                    /     \              /      \
                   1-n/4  n/4+1-n/2   n/2-3n/4 3n/4+1-n
            Height of the tree is log2(n) and at each level O(n) time is required to find pivot so best time complexity is O(nlogn)

Worst Case is when the array is already sorted, then O(n+n-1+n-2+n-3+....+1) time is required to sort the array.O(n*(n+1)/2)->O(n*n)
*/ 