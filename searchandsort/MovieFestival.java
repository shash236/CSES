import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MovieFestival {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        out.println(solve(arr,n));
        out.flush();
        out.close();
    }
    
    private static int solve(int[][] arr, int n) {
        int count = 1;
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int[] prev = arr[0];
        for(int i = 1; i < n; i++) {
            int[] curr = arr[i];
            if(prev[1] <= curr[0]){
                count++;
                prev = curr;
            }else {
                if(prev[1] > curr[1]) {
                    prev = curr;
                }
            }
        }

        return count;
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
    