import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RectangleCutting {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        out.println(solve(a, b));
        out.flush();
        out.close();
    }

    private static int solve(int a, int b) {
        int[][] dp = new int[a+1][b+1];
        for(int i = 1; i <= a; i++) { dp[i][1] = i-1; }
        for(int i = 1; i <= b; i++) { dp[1][i] = i-1; }

        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= b; j++) {
                if(i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                int minVal = Integer.MAX_VALUE;
                for (int k = 1; k <= i/2; k++) {
                    minVal = Math.min(minVal,1+ dp[k][j] + dp[i-k][j]);
                }
                for (int k = 1; k <= j/2 ; k++) {
                    minVal = Math.min(minVal,1+ dp[i][k] + dp[i][j-k]);
                }
                dp[i][j] = minVal;
            }
        }

        return dp[a][b];
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
