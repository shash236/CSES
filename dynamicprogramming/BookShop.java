import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BookShop {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }
        out.println(solve(n, x, prices, pages));
        out.flush();
        out.close();
    }

    private static int solve(int n, int x, int[] prices, int[] pages) {
        int[][] dp = new int[n][x+1];
        
        //initialize values
        for(int i = 0; i <= x; i++) {
            dp[n-1][i] = (i >= prices[n-1]) ? pages[n-1] : 0;
        }
        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        //top-down
        for(int i = n-2; i >= 0; i--) {
            for(int j = 0; j <= x; j++) {
                if(j - prices[i] < 0){
                    dp[i][j] = dp[i+1][j];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], pages[i] + dp[i+1][j - prices[i]]);
                }
            }
        }

        return dp[0][x];
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
