import java.util.Scanner;
//studied the algo from gfg and implemented it but still not sure whether i get it 100% or not.Fractional knapsack is way easier then this. 
public class Matric_Chain_Multiplication {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        System.out.println(matric_chain_multiplication(a,1,n-1));
    }   
    static int matric_chain_multiplication(int[] a,int i,int j){
        if(i==j)return 0;
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            ans=Math.min(ans,a[k]*a[i-1]*a[j]+matric_chain_multiplication(a, i, k)+matric_chain_multiplication(a, k+1, j));
        }
        return ans;
    }
}
