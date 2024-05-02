import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayDescription {

    private final static int M = 1000000007; 

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(n, m, arr));

        out.flush();
        out.close();
    }

    private static int solve(int n, int m, int[] arr) {
        int[][] dp = new int[n][m+1];
        //initalize
        if(arr[0]==0){
            for (int i = 1; i <= m; i++) {
                dp[0][i] = 1;
            }
        }else {
            dp[0][arr[0]] = 1;
        }

        //top-down
        for(int i = 1; i < n; i++) {
            if(arr[i] == 0) { 
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = calculate(i, j, m, dp);
                }
            }else {
                dp[i][arr[i]] = calculate(i, arr[i], m, dp);
            }
        }
        
        //result
        if(arr[n-1] == 0){
            int sum = 0;
            for (int i = 1; i <= m; i++) {
                sum += dp[n-1][i];
                sum %= M;
            }
            return sum;
        }else {
            return dp[n-1][arr[n-1]];
        }
    }

    private static int calculate(int i, int j, int m, int[][] dp) {
        long val = (long)dp[i-1][j] + ((j > 1) ? dp[i-1][j-1] : 0) 
        + ((j < m) ? dp[i-1][j+1] : 0);
        val %= M;
        return (int)val;
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