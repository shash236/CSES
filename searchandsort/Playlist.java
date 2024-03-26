import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Playlist {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        out.println(solve(n, arr));
        
        out.flush();
        out.close();
    }

    private static int solve(int n, int[] arr){
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int start  = 0;
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                maxLength = Math.max(maxLength,i - start);
                int duplicate = map.get(arr[i]);
                for(int j = start; j <= duplicate; j++){
                    map.remove(arr[j]);
                }
                start = duplicate + 1;
            }
            map.put(arr[i],i);
        }
        maxLength = Math.max(maxLength,map.size());
        return maxLength;
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
