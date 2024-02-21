import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberSpiral {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = fastReader.nextInt();
        for(int i = 0; i < t; i++){
            long y = fastReader.nextInt();
            long x = fastReader.nextInt();
            if(y >= x){
                if(y%2==0) out.println(y*y - x + 1);
                else out.println((y-1)*(y-1) + x);
            }else{
                if(x%2==0) out.println((x-1)*(x-1) + y);
                else out.println(x*x - y + 1);
            }
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


