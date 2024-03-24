import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumOfTwoValues {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] soln = solve(x, arr, n);
        if(soln==null){
            out.println("IMPOSSIBLE");
        }else{
            out.println((soln[0]+1) + " " + (soln[1]+1));
        }
        out.flush();
        out.close();
    }

    private static int[] solve(int x, int[] arr, int n) {
        final Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.get(arr[i])==null){
                map.put(arr[i],new int[] {i,-1});
            }else{
                map.get(arr[i])[1] = i;
            }
        }

        for(int i = 0; i < n; i++) {
            int y = x - arr[i]; // y + arr[i] = x
            int[] yPositions = map.get(y);
            if(yPositions!=null){
                if(yPositions[0] != i){
                    return new int[] {i,yPositions[0]};
                }else if(yPositions[1] != -1){
                    return new int[] {i,yPositions[1]};
                }
            }
        }

        return null;
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
