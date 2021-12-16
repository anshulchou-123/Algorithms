import java.util.Scanner;
import java.util.*;

public class Merge_Sort{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n=s.nextInt();
        System.out.println("Enter"+" "+n+" "+"elements");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        merge_sort(arr,5,9);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        s.close();
    }
    public static void merge_sort(int[] arr, int l, int r){
        if(l>=r)return ;
        int mid=(l+r)/2;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }
    static void merge(int[] arr, int l, int mid, int r){
        int[] left=new int[mid-l+1];
        int[] right=new int[r-mid];
        for(int i=l;i<=mid;i++){
            left[i-l]=arr[i];
        }
        for(int i=mid+1;i<=r;i++){
            right[i-(mid+1)]=arr[i];
        }
        int left_start=0;
        int right_start=0;
        int left_length=mid-l+1;
        int right_length=r-mid;
        int temp=l;
        while(left_start<left_length && right_start<right_length){
            if(left[left_start]<right[right_start]){
                arr[temp]=left[left_start++];
            }else{
                arr[temp]=right[right_start++];
            }
            temp++;
        }
        while(left_start<left_length){
            arr[temp++]=left[left_start++];
        }
        while(right_start<right_length){
            arr[temp++]=right[right_start++];
        }
    }
}