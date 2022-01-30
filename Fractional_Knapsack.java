/* 
Problem_Statement- You are given n weights and their values(w1->v1,w2->v2,....wn->vn) and a bag of capacity W. What is the maximum value we can get by addding weights inside bag such that sum of those weights is less then W and the sum of their values is maximum, also we can take a portion of a weight as well(ex: from w1 you can take only w1/3 part only by taking value v1/3).

Now suppose for a given element its weight  is w kg and its value is v,then 
    w=v;(from w i can get a value v)
    divide both sides by w;
    1kg=v/w;(means from onlt 1th part of w(i.e 1kg), i can v/w value)
    Here every element can be divided into 1kg  part and everry 1kg part would have v/w value, so its optimal to take that 1kg weight which gives us maximum v/w value.Hence we can take elements greedily.Hence fractional knapsack is easier then 0/1 knapsack.

Ex: (10->10, 6->12, 6->18)
       1st    2nd    3rd
    
    1kg of 1st gives 1 value
    1kg of 2nd gives 2 value
    1kg of 3rd gives 3 value

    means 1st can be divided into 10 part, 2nd can be didvide into 6 part, 3rd can be divided into 6 part, Below i'm writing every 1kg item and its corresponding values
    
Values :                1   1   1   1   1   1   1   1   1   1   2   2   2   2   2   2   3   3   3   3   3   3
Weight                 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg 1kg
Item number:           1st 1st 1st 1st 1st 1st 1st 1st 1st 1st 2nd 2nd 2nd 2nd 2nd 2nd 3rd 3rd 3rd 3rd 3rd 3rd

Now if bag is of weight 5kg its optimal to choose the last 5 1kg weight with maximum value,so we get a value of 15.
*/
import java.util.*;
import java.io.*;

public class Fractional_Knapsack {
    static class Item{
        int w,v;
        public Item(int w,int v){
            this.w=w;
            this.v=v;
        }
    }
    static class comparator implements Comparator<Item>{
        public int compare(Item a,Item b){
            return a.v/(a.w*1.0)-b.v/(b.w*1.0)>=0?1:-1;
        }
    }
    public static void main(String[]  args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        for(int i=0;i<n;i++){
            w[i]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            v[i]=s.nextInt();
        }
        TreeSet<Item> set=new TreeSet<>(new comparator());
        for(int i=0;i<n;i++){
            set.add(new Item(w[i],v[i]));
        }
        int W=s.nextInt();
        double ans=0;
        int rem=W;
        while(!set.isEmpty()){
            Item i=set.pollLast();
            System.out.println(i.v+" "+i.w);
            if(rem>=i.w){
                ans+=(double)i.v;
                rem-=i.w;
            }else{
                ans+=(i.v/(1.0*i.w))*rem;
                System.out.println((i.v/(1.0*i.w))*rem);
                break;
            }
        }
        System.out.println(ans);
        s.close();
    }
}
