import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Main {
    static FastReader in;
    static PrintWriter out;

    static int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
        out.println(o);
    }

    static void pni(Object o) {
        out.println(o);
        out.flush();
    }

    static String n() throws Exception {
        return in.next();
    }

    static String nln() throws Exception {
        return in.nextLine();
    }

    static int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    static long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    static double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    static class FastReader {
        static BufferedReader br;
        static StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }

    static long power(long a, long b) {
        if (a == 0L)
            return 0L;
        if (b == 0)
            return 1;
        long val = power(a, b / 2);
        val = val * val;
        if ((b % 2) != 0)
            val = val * a;
        return val;
    }

    static long power(long a, long b, long mod) {
        if (a == 0L)
            return 0L;
        if (b == 0)
            return 1;
        long val = power(a, b / 2L, mod) % mod;
        val = (val * val) % mod;
        if ((b % 2) != 0)
            val = (val * a) % mod;
        return val;
    }

    static ArrayList<Long> prime_factors(long n) {
        ArrayList<Long> ans = new ArrayList<Long>();
        while (n % 2 == 0) {
            ans.add(2L);
            n /= 2L;
        }
        for (long i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                ans.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            ans.add(n);
        }
        return ans;
    }

    static void sort(ArrayList<Long> a) {
        Collections.sort(a);
    }

    static void reverse_sort(ArrayList<Long> a) {
        Collections.sort(a, Collections.reverseOrder());
    }

    static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void swap(List<Long> a, int i, int j) {
        long temp = a.get(i);
        a.set(j, a.get(i));
        a.set(j, temp);
    }

    static void sieve(boolean[] prime) {
        int n = prime.length - 1;
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void sort(long[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];
        for (int i = l; i <= mid; i++) {
            left[i - l] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            right[i - (mid + 1)] = arr[i];
        }
        int left_start = 0;
        int right_start = 0;
        int left_length = mid - l + 1;
        int right_length = r - mid;
        int temp = l;
        while (left_start < left_length && right_start < right_length) {
            if (left[left_start] < right[right_start]) {
                arr[temp] = left[left_start++];
            } else {
                arr[temp] = right[right_start++];
            }
            temp++;
        }
        while (left_start < left_length) {
            arr[temp++] = left[left_start++];
        }
        while (right_start < right_length) {
            arr[temp++] = right[right_start++];
        }
    }

    static void merge(long[] arr, int l, int mid, int r) {
        long[] left = new long[mid - l + 1];
        long[] right = new long[r - mid];
        for (int i = l; i <= mid; i++) {
            left[i - l] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            right[i - (mid + 1)] = arr[i];
        }
        int left_start = 0;
        int right_start = 0;
        int left_length = mid - l + 1;
        int right_length = r - mid;
        int temp = l;
        while (left_start < left_length && right_start < right_length) {
            if (left[left_start] < right[right_start]) {
                arr[temp] = left[left_start++];
            } else {
                arr[temp] = right[right_start++];
            }
            temp++;
        }
        while (left_start < left_length) {
            arr[temp++] = left[left_start++];
        }
        while (right_start < right_length) {
            arr[temp++] = right[right_start++];
        }
    }

    static class pair implements Comparable<pair> {
        long a, b;

        public pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(pair p) {
            if (this.a == p.a) {
                return this.b - p.b > 0 ? 1 : -1;
            }
            return this.a > p.a ? 1 : -1;
        }

    }

    static HashMap<Long, Integer> map_prime_factors(long n) {
        HashMap<Long, Integer> map = new HashMap<>();
        while (n % 2 == 0) {
            map.put(2L, map.getOrDefault(2L, 0) + 1);
            n /= 2L;
        }
        for (long i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map;
    }

    static long divisor(long n) {
        long count = 0;
        for (long i = 1L; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i)
                    count = (count + i) % mod;
                else {
                    count = (count + i) % mod;
                    count = (count + n / i) % mod;
                }
            }
        }
        return count;
    }

    // static void smallest_prime_factor(int n) {
    // smallest_prime_factor[1] = 1;
    // for (int i = 2; i <= n; i++) {
    // if (smallest_prime_factor[i] == 0) {
    // smallest_prime_factor[i] = i;
    // for (int j = i * i; j <= n; j += i) {
    // if (smallest_prime_factor[j] == 0) {
    // smallest_prime_factor[j] = i;
    // }
    // }
    // }
    // }
    // }

    // static int[] smallest_prime_factor;
    // static int count = 1;
    // static int[] p = new int[100002];
    // static long[] flat_tree = new long[300002];
    // static int[] in_time = new int[1000002];
    // static int[] out_time = new int[1000002];
    // static long[] subtree_gcd = new long[100002];
    // static int w = 0;
    // static boolean poss = true;
    static long mod = 1000000007L;

    /*
     * (a^b^c)%mod
     * Using fermats Little theorem
     * x^(mod-1)=1(mod)
     * so b^c can be written as b^c=x*(mod-1)+y
     * then (a^(x*(mod-1)+y))%mod=(a^(x*(mod-1))*a^(y))mod
     * the term (a^(x*(mod-1)))%mod=a^(mod-1)*a^(mod-1)
     * 
     */

    static class node {
        int v, w;

        public node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class comparator implements Comparator<node> {
        public int compare(node a, node b) {
            return a.w - b.w;
        }
    }

    public static void main(String[] args) throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int tc = ni();
        while (tc-- > 0) {
            int n = ni();
            int[] dis = new int[n+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            List<List<node>> arr = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                arr.add(i, new ArrayList<node>());
            }
            int m =ni();
            for (int i = 0; i < m; i++) {
                int a =ni();
                int b = ni();
                int w = 6;
                arr.get(a).add(new node(b,w));
                arr.get(b).add(new node(a,w));
            }
            int k = ni();
            dis[k] = 0;
            PriorityQueue<node> set = new PriorityQueue<>(new comparator());
            boolean[] included = new boolean[n+1];
            set.add(new node(k, 0));
            for (int i = 1; i <=n; i++) {
                if (i == k)continue;
            }
            // for(node e:set){
            //     pn(e.v+" "+e.w);
            // }
            while (!set.isEmpty()) {
                node e = set.poll();
                if(included[e.v])continue;
                included[e.v] = true;
                for (node neighbour : arr.get(e.v)) {
                    if (!included[neighbour.v]) {
                        int new_distance=Math.min(dis[neighbour.v] , dis[e.v] + neighbour.w);
                        set.add(new node(neighbour.v, new_distance));
                        dis[neighbour.v]=new_distance;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if(i==k)continue;
                if(dis[i]==Integer.MAX_VALUE)p("-1 ");
                else p(dis[i]+" ");
            }
            pn("");
        }
        out.flush();
        out.close();
    }

    static void dfs(int i, List<List<Integer>> arr, boolean[] visited, int[] dis) {
        for (int n : arr.get(i)) {
            if (!visited[n]) {
                dis[n] = Math.min(dis[n], 6 + dis[i]);
                visited[n] = true;
                dfs(n, arr, visited, dis);
            }
        }
        for (int n : arr.get(i)) {
            dis[n] = Math.min(dis[i] + 6, dis[n]);
        }
    }

    static TreeSet<Integer> ans(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        set.remove(1);
        return set;
    }

    // static long find(String s, int i, int n, long[] dp) {
    // // pn(i);
    // if (i >= n)
    // return 1L;
    // if (s.charAt(i) == '0')
    // return 0;
    // if (i == n - 1)
    // return 1L;
    // if (dp[i] != -1)
    // return dp[i];
    // if (s.substring(i, i + 2).equals("10") || s.substring(i, i + 2).equals("20"))
    // {
    // return dp[i] = (find(s, i + 2, n, dp)) % mod;
    // }
    // if ((s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) - '0' <=
    // 6))
    // && ((i + 2 < n ? (s.charAt(i + 2) != '0' ? true : false) : (i + 2 == n ? true
    // : false)))) {
    // return dp[i] = (find(s, i + 1, n, dp) + find(s, i + 2, n, dp)) % mod;
    // } else
    // return dp[i] = (find(s, i + 1, n, dp)) % mod;

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            p(a[i] + " ");
        pn("");
    }

    static long count(long n) {
        long count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    static void swap(long a, long b) {
        long temp = a;
        a = b;
        b = temp;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int LcsOfPrefix(String a, String b) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
                count++;
            }
            i++;
        }
        return a.length() + b.length() - 2 * count;
    }

    static void reverse(int[] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    static char get_char(int a) {
        return (char) (a + 'a');
    }

    static void dfs(int i, List<List<Integer>> arr, boolean[] visited, int parent) {
        visited[i] = true;
        for (int v : arr.get(i)) {
            if (!visited[v]) {
                dfs(v, arr, visited, i);
            }
        }
    }

    static int find1(List<Integer> a, int val) {
        int ans = -1;
        int l = 0;
        int r = a.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) >= val) {
                r = mid - 1;
                ans = mid;
            } else
                l = mid + 1;
        }
        return ans;
    }

    static int find2(List<Integer> a, int val) {
        int l = 0;
        int r = a.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) <= val) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    // static void dfs(List<List<Integer>> arr, int node, int parent, long[] val) {
    // p[node] = parent;
    // in_time[node] = count;
    // flat_tree[count] = val[node];
    // subtree_gcd[node] = val[node];
    // count++;
    // for (int adj : arr.get(node)) {
    // if (adj == parent)
    // continue;
    // dfs(arr, adj, node, val);
    // subtree_gcd[node] = gcd(subtree_gcd[adj], subtree_gcd[node]);
    // }
    // out_time[node] = count;
    // flat_tree[count] = val[node];
    // count++;
    // }
}
