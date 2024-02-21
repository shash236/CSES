import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoKnights {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int attackingCombinations = 0;
        for(int k = 1; k <= n; k++){
            int ksq = k*k;
            long totolCombos = ((long)ksq * (ksq-1))/2;
            if(k == 3){
                attackingCombinations = 8;
            }else if(k > 3){
                //new column
                attackingCombinations += 10;
                attackingCombinations += (k - 4)*4;

                //new row
                attackingCombinations += 10;
                if(k > 4) attackingCombinations += (k-5)*4;
                else attackingCombinations -= 4;
            }
            out.println(totolCombos - attackingCombinations);
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
