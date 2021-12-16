import java.io.*;
import java.lang.*;
import java.util.*;

public class Segment_Tree{
    static long[] ans;
    static long[] arr;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int q=s.nextInt();
            arr=new long[n];
            ans=new long[2*n+1];
            for(int i=0;i<n;i++){
                arr[i]=s.nextLong();
            }
            build(1,0,n-1);
            while(q-->0){
                int x=s.nextInt();
                int l=s.nextInt();
                int r=s.nextInt();
                if(x==2)System.out.println(query(1,0,n-1,l,r-1));
                if(x==1)update(l,1,0,n-1,r);
            }

        }
        s.close();
    }

    static void build(int id,int l,int r){
        if(l==r){
            ans[id]=arr[l];
            return ;
        }
        int mid=(l+r)/2;
        build(2*id,l,mid);
        build(2*id+1,mid+1,r);
        ans[id]=ans[2*id]+ans[2*id+1];
    }

    static void update(int p,int id,int l,int r,int val){
        if(l==r){
            arr[l]=val;
            ans[id]=val;
            return ;
        }
        int mid=(l+r)/2;
        if(p<=mid){
            update(p,2*id,l,mid,val);
        }else{
            update(p,2*id+1,mid+1,r,val);
        }
        ans[id]=ans[2*id]+ans[2*id+1];
    }

    static long query(int id,int l,int r,int x,int y){
        if(r<x || l>y)return 0;
        if(l>=x && r<=y){
            return ans[id];
        }

        int mid=(l+r)/2;
        return query(2*id,l,mid,x,y)+query(2*id+1,mid+1,r,x,y);
    }
}

