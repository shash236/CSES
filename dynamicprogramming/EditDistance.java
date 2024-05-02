import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EditDistance {
    
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String x = scanner.next();
        String y = scanner.next();
        out.println(solve(x,y));
        out.flush();
        out.close();
    }
    
    private static int solve(String x, String y) {
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i = 0; i <= x.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= y.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                dp[i][j] = Math.min(1+dp[i-1][j],1+dp[i][j-1]);
                dp[i][j] = Math.min(dp[i][j], ((x.charAt(i-1) == y.charAt(j-1)) ? 0 : 1) + dp[i-1][j-1]);
            }
        }
        return dp[x.length()][y.length()];
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