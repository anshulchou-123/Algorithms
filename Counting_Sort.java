import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class Counting_Sort {
   public static void main(String[] args){
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int k=s.nextInt();
       int[] a=new int[n];
       int[] count=new int[k+1];
       for(int i=0;i<n;i++){
           a[i]=s.nextInt();
           count[a[i]]++;
       }
       int[] pre=new int[k+1];
       pre[0]=0;
       for(int i=1;i<=k;i++){
           pre[i]=pre[i-1]+count[i-1];
       }
       int[] ans=new int[n];
       for(int i=0;i<n;i++){
           ans[pre[a[i]]]=a[i];
           pre[a[i]]++;
       }
       for(int i=0;i<n;i++)System.out.print(ans[i]+" ");
       System.out.println("");
       s.close();
   } 
}

/*
->Count the no. of occurence of each number from 1 to k
->Then for each element "i" find first index where this element "i" will come in array pre[]
  ex: Array a-> 1,2,3,3,3,4
                0 1 2 3 4 5

      pre[1]->0,pre[2]->1,pre[3]->2,pre[4]->5
   
->Traverse the given array a[] from left to right and place the element at pre[a[i]] now the next occurence of a[i] should be present at pre[a[i]]+=1
Time Complexity-O(n+k)
*/
