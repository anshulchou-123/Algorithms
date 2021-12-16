/*
Problem Statement:
   Given m boards of length {l1,l2,..,lm} and k painters ,each painter takes 1 unit of time to paint 1 unit of board,find minimum time to paint all boards.Each painter can paint only a continuos section of boards.
*/

import java.util.*;
public class Binary_Search {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int k=s.nextInt();
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int ans=-1;
        int l=1;
        int r=1000000000;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(can_paint(a,mid,k)){//if we can paint all the boards in mid time then we can definetly paint all board from time mid+1 to inf
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        System.out.println(ans);
    }
    static boolean can_paint(int[] a,int time,int k){
        int curr_time=0;//we will assign the job of painting the ith board  
        int count=0;//no. of person used till now to paint the board
        for(int i=0;i<a.length;i++){
            if(curr_time+a[i]>time){
                count++;
                if(count>=k)return false;//if no more persons left to paint board 
                if(a[i]>time)return false;//if this board can't be painted in the whole time "time"
                curr_time=a[i];
            }else curr_time+=a[i];//otherwise simply assign this board to "count" person
        }
        return true;//we have painted all board in less then "mid" time
    }
}
