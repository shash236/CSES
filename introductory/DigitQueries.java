import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class DigitQueries {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        // Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++){
            out.println(solve(scanner.nextLong()));
            // System.out.println(solve(scanner.nextLong()));
        }
 
        out.flush();
        out.close();
    }
 
    private static int solve(long x) {
        if(x < 10) return (int)x;
        InnerDigitQueries idq = calculate(x);
        long val = x - idq.val - 1;
        long q = val / idq.n;
        int r = (int) (val % idq.n);
        Long v = (long)Math.pow(10,idq.n-1) + q;
        return v.toString().charAt(r) - '0';
    }
 
    private static InnerDigitQueries calculate(long x) {
        int n = 0;
        long val = 0;
        long lastVal = 0;
        while(val < x){
            lastVal = val;
            val += 9 * n * (long)Math.pow(10,n-1);
            n++;
        }
        return new InnerDigitQueries(n-1,lastVal);
    }
 
    private static class InnerDigitQueries {
        public int n;
        public long val;
 
        public InnerDigitQueries(int n, long val){
            this.n = n;
            this.val = val;
        }
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