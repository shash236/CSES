import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimizingCoins {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(x, n, arr));
        out.flush();
        out.close();
    }
    
    private static int solve(int x, int n, int[] coins) {
        int[] dp = new int[x+1];
        for(int val = 1; val <= x; val++) {
            int minCoins = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(val - coins[i] >= 0 && dp[val - coins[i]] != -1){
                    minCoins = Math.min(minCoins,1 + dp[val - coins[i]]);
                }
            }
            if(minCoins != Integer.MAX_VALUE) {
                dp[val] = minCoins;
            }else {
                dp[val] = -1;
            }
        }
        return dp[x];
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
