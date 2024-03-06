import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AppleDivision {

    private static long mindiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        long arrSum  = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            arrSum += arr[i];
        }
        Arrays.sort(arr);
        backtracking(0, arr, 0, arrSum);
        out.println(mindiff);
        out.flush();
        out.close();
    }

    //edge case [1]
    private static void backtracking(long currsum, int[] arr, int len, long arrSum) {
        if(len == arr.length) {
            if(currsum == 0) return;
            mindiff = Math.min(mindiff,Math.abs(arrSum - 2*currsum));
            return;
        }
        currsum += arr[len];
        backtracking(currsum, arr, len+1,arrSum);
        currsum -= arr[len];
        backtracking(currsum, arr, len+1, arrSum);
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
