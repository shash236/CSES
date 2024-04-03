import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RoomAllocation {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        solve(n, arr);
    }

    private static void solve(int n, int[][] arr) {
        int[][] ranges = new int[2*n][3];
        int p = 0;
        for(int i = 0; i < n; i++) {
            ranges[p][0] = arr[i][0];
            ranges[p][1] = 1;
            ranges[p][2] = i;
            p++;
            ranges[p][0] = arr[i][1] + 1;
            ranges[p][1] = -1;
            ranges[p][2] = i;
            p++;
        }

        Arrays.sort(ranges,(a,b)->{
            return a[0]!=b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1], b[1]);
        });

        int[] ans = new int[n];
        int maxRooms = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*n; i++) {
            int[] range = ranges[i];
            if(range[1] == 1){
                if(stack.isEmpty()) {
                    maxRooms++;
                    stack.push(maxRooms);
                }
                ans[range[2]] = stack.pop();
            }else{
                stack.push(ans[range[2]]);
            }
        }

        // print the ans
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.println(maxRooms);
        for (int i : ans) {
            out.print(i);
            out.print(' ');
        }
        out.flush();
        out.close();
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
