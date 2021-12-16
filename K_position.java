//Anshul Chouhan
//0801IT191012

import java.util.Scanner;

public class K_position {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int m = s.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = s.nextInt();
        }
        int k = s.nextInt();
        if (k > (n + m)) {
            System.out.println("-1");
            return;
        }
        int count = 0;
        int first = 0;
        int second = 0;
        while (first < n && second < m) {
            if (a[first] < b[second]) {
                first++;
                count++;
                if (count == k) {
                    System.out.println(a[first - 1]);
                    s.close();
                    return;
                }
            } else {
                second++;
                count++;
                if (count == k) {
                    System.out.println(b[second - 1]);
                    s.close();
                    return;
                }
            }
        }

        while (first < n) {
            first++;
            count++;
            if (count == k) {
                System.out.println(a[first - 1]);
                s.close();
                return;
            }
        }
        while (second < m) {
            second++;
            count++;
            if (count == k) {
                System.out.println(b[second - 1]);
                s.close();
                return;
            }
        }
    }
}
