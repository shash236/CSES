import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemovalGame {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(n, arr));
        out.flush();
        out.close();
    }
    
    private static long solve(int n, int[] arr) {
        long dp[][] = new long[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        long[] presum = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            presum[i] = sum;
        }

        for(int diff = 1; diff < n; diff++) {
            for(int i = 0; i < n; i++) {
                int j = i + diff;
                if(j >= n) break;
                long sumleft = presum[j] - presum[i];
                long sumright = presum[j-1] - (i==0 ? 0 : presum[i-1]);
                dp[i][j] = Math.max(arr[i] + sumleft - dp[i+1][j], arr[j] + sumright - dp[i][j-1]);
            }
        }

        return dp[0][n-1];
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
