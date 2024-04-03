import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FactoryMachines {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        // Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(n, t, arr));
        
        out.flush();
        out.close();
    }

    private static long solve(int n, int t, int[] arr) {
        long s = 0;
        int minval = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) { minval = Math.min(minval, arr[i]); }
        long e = minval * (long)t;
        long ans = -1;
        while(s <= e) {
            long mid = s + (e - s)/2;
            long val = calculateProducts(n, mid, arr);
            if(val == t){
                ans = mid;
                e = mid - 1;
            }else if(val < t) {
                s = mid + 1;
            }else{
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }

    private static long calculateProducts(int n, long s, int[] arr) {
        long totalProducts = 0;
        for(int i = 0; i < n; i++) {
            totalProducts += s/arr[i];
        }
        return totalProducts;
    }

    static class FastReader {
 
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
