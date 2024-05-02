import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CoinCombinationsII {
    private static final int m = 1000000007;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(n, x, arr));
        out.flush();
        out.close();
    }

    private static int solve(int n, int x, int[] coins) {
        int[][] arr = new int[x+1][n];
        arr[0][0] = 1;

        for(int i = 1; i <= x; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coins[j] >= 0) {
                    arr[i][j] = 0;
                    for(int k = 0; k <= j; k++){
                        arr[i][j] += arr[i - coins[j]][k];
                        arr[i][j] %= m;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) { ans = (ans + arr[x][i])%m; }
        return ans;
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
