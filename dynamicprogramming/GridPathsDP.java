import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GridPathsDP {

    private static final int m = 1000000007;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = scanner.nextLine(); 
            for(int j = 0; j < n; j++) {
                arr[i][j] = (line.charAt(j) == '*') ? -1 : 0;
            }
        }
        
        out.println(solve(n, arr));
        out.flush();
        out.close();
    }

    private static int solve(int n, int[][] arr) {
        if(arr[n-1][n-1] == -1 || arr[0][0] == -1) return 0;
        else arr[n-1][n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(arr[n-1][i] == -1) continue;
            arr[n-1][i] = (arr[n-1][i+1]== -1) ? 0 : arr[n-1][i+1];
        }
        for(int i = n-2; i >= 0; i--) {
            if(arr[i][n-1] == -1) continue;
            arr[i][n-1] = (arr[i+1][n-1] == -1) ? 0 : arr[i+1][n-1];
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                if(arr[i][j] == -1) continue;
                arr[i][j] = (arr[i][j+1] == -1 ? 0 : arr[i][j+1]) +  
                    (arr[i+1][j] == -1 ? 0 : arr[i+1][j]);
                arr[i][j] %= m;
            }
        }

        return arr[0][0];
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
