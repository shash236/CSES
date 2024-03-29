import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JosephusProblemII {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ans = solve(n,k);
        for (int a : ans) {
            out.println(a);
        }
        
        out.flush();
        out.close();
    }

    private static int[] solve(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) { list.add(i); }
        int p = k%n;
        int i = 0;
        int[] ans = new int[n];
        while(!list.isEmpty()){
            ans[i] = list.get(p);
            list.remove(p);
            if(!list.isEmpty()){
                p = (p+k) % list.size();
            }
            i++;
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