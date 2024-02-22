import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoSets {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        long total = ((long)n * (n+1))/2;
        if(total%2 == 1){
            out.println("NO");
            out.flush();
            out.close();
            return;
        }

        long setATotalLeft = total/2;
        List<Integer> setA = new ArrayList<>();
        List<Integer> setB = new ArrayList<>();
        for(int i = n; i > 0; i--) {
            if(setATotalLeft - i >= 0){
                setA.add(i);
                setATotalLeft-=i;
            }else{
                setB.add(i);
            }
        }

        out.println("YES");
        out.println(setA.size());
        for (Integer integer : setA) {
            out.print(integer + " ");
        }
        out.println();
        out.println(setB.size());
        for (Integer integer : setB) {
            out.print(integer + " ");
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