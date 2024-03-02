
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoinPiles {
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        // Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean isPossible = ((2*a - b) >= 0) && ((2*a - b)%3 == 0)
                && ((2*b - a) >= 0) && ((2*b - a)%3 == 0);
            out.println(isPossible ? "YES" : "NO");
        }

        // scanner.close();
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
