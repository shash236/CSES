import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RestaurantCustomers {
    
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        out.println(solve(arr, n));
        out.flush();
        out.close();
    }

    private static int solve(int[][] arr, int n){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i< n; i++) {
            if(map.get(arr[i][0])==null){
                map.put(arr[i][0],1);
            }else{
                map.put(arr[i][0],map.get(arr[i][0])+1);
            }

            if(map.get(arr[i][1])==null){
                map.put(arr[i][1],-1);
            }else{
                map.put(arr[i][1],map.get(arr[i][1])-1);
            }
        }
        int curr = 0;
        int maxval = 0;
        for(int pos : map.keySet()){
            curr += map.get(pos);
            maxval = Math.max(curr,maxval);
        }
        return maxval;
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