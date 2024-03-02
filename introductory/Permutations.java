
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Permutations {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int n = scanner.nextInt();
        if(n == 2 || n == 3){
            System.out.println("NO SOLUTION");
        }else{
            // print all even numbers till n
            int num = 2;
            while(num <= n){
                out.print(num);
                out.print(' ');
                num+=2;
            }
            // print all odd numbers till n
            num = 1;
            while(num <= n){
                out.print(num);
                out.print(' ');
                num+=2;
            }
        }
        
        out.println();
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
