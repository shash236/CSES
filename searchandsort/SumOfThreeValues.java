import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfThreeValues {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = i;
        }
        int[] ans =  solve(n, x, arr);
        if(ans==null) out.println("IMPOSSIBLE");
        else {
            out.println((ans[0]+1) + " " + (ans[1]+1) + " " + (ans[2]+1));
        }
        out.flush();
        out.close();
    }

    private static int[] solve(int n, int x, int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[0], b[0]));
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                int[] p = bs(n, x - arr[i][0] - arr[j][0], j+1, arr);
                if(p != null){
                    return new int[] {arr[i][1], arr[j][1], p[1]};
                }
            }
        }
        return null;
    }

    private static int[] bs(int n, int x, int s, int[][] arr) {
        int e = n-1;
        int p = -1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(arr[mid][0] == x){
                p = mid;
                break;
            }else if (arr[mid][0] < x) {
                s = mid + 1;
            }else {
                e = mid - 1;
            }
        } 
        return p!=-1 ? arr[p] : null;
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
