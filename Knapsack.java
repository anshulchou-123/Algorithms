import java.util.*;
//Given n elements with a fixed weight and value(w1->v1,w2->v2,w3->v3,.....,wn->vn), and a bag of capacity W , find the maximum value you can obtained by putting elements inside the bag such that sum of their weights are less then W and the sum of their values is maximum
class Knapsack {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] weight=new int[n];
        int[] value=new int[n];
        for(int i=0;i<n;i++){
            weight[i]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            value[i]=s.nextInt();
        }
        //If we know the maximum value we can obtain by using first i elements, for a bag with capacity ranging from 1 to W, then we can find the maximum value we can obtain using i+1 elements as well
        //So, let dp[i][j] denotes maximum value we can obtain by using first i elments by placing them inside a bag of weight j
        //then, dp[i+1][j]=Math.max(dp[i][j],value[i+1]+dp[i][j-weight[i+1]]);
        int W=s.nextInt();
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int w=1;w<=W;w++){
                if(w>=weight[i-1]){
                    dp[i][w]=Math.max(dp[i-1][w],value[i-1]+dp[i-1][w-weight[i-1]]);
                }else dp[i][w]=dp[i-1][w];
                System.out.print(dp[i][w]+" ");
            }
            System.out.println("");
        }
        System.out.println(dp[n][W]);
    }
}