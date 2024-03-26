import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CollectingNumbersII {
    
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][] swaps = new int[m][2];
        for(int i = 0; i < m; i++) {
            swaps[i][0] = scanner.nextInt();
            swaps[i][1] = scanner.nextInt();
        }

        int[] ans = solve(n, m, arr, swaps);
        for (int num : ans) {
            out.println(num);
        }
        out.flush();
        out.close();
    }

    private static int[] solve(int n, int m, int[] arr, int[][] swaps) {
        int[] positions = new int[n+1];
        int[] ans = new int[m];
        for(int i = 0; i < n; i++){
            positions[arr[i]] = i+1; 
        }
        int rounds = 1;
        for(int j = 1; j < n+1; j++){
            if(positions[j] < positions[j-1]){
                rounds++;
            }
        }

        for(int i = 0; i < m; i++) {
            int a = swaps[i][0]; int aVal = arr[a-1];
            int b = swaps[i][1]; int bVal = arr[b-1];
            
            // a position
            if(positions[aVal] < positions[aVal-1]) rounds--;
            if(aVal != n && positions[aVal] > positions[aVal+1]) rounds--;
            positions[aVal] = b;
            if(positions[aVal] < positions[aVal-1]) rounds++;
            if(aVal != n && positions[aVal] > positions[aVal+1]) rounds++;

            //b position
            if(positions[bVal] < positions[bVal-1]) rounds--;
            if(bVal != n && positions[bVal] > positions[bVal+1]) rounds--;
            positions[bVal] = a;
            if(positions[bVal] < positions[bVal-1]) rounds++;
            if(bVal != n && positions[bVal] > positions[bVal+1]) rounds++;

            ans[i] = rounds;

            int temp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = temp;
        }
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
