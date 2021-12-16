import java.util.*;

public class Kadane_Algo {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        String s = ss.next();
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                arr[i] = -1;
            else
                arr[i] = 1;
        }
        int curr_sum = 0;
        int max = 0;
        int l = 0;
        int L = -1;//L and r  store the starting and ending index of maximum subarray
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (curr_sum + arr[i] < 0) {
                l = i + 1;
                curr_sum = 0;
            } else
                curr_sum += arr[i];
            if (max < curr_sum) {
                max = curr_sum;
                L = l;
                r = i;
            }
        }
        if (L == -1)
            return ;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(L + 1);
        a.add(r + 1);
        System.out.print(a);
    }
}
