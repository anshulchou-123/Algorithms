import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.io.*;
//All pair shortest Path algorithm
class FlyodWarshall{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)arr[i][j]=Integer.MAX_VALUE;
            }
        }
        int m=s.nextInt();
        for(int i=0;i<m;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            int w=s.nextInt();
            arr[a][b]=w;
            arr[b][a]=w;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(arr[i][k]!=Integer.MAX_VALUE && arr[k][j]!=Integer.MAX_VALUE && arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
    }
}