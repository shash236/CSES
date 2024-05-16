import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class MoneySums {

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

    private static String solve(int n, int[] arr) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            Set<Integer> temp = new HashSet<>();
            for (Integer integer : set) {
                temp.add(integer + x);
            }
            set.add(x);
            set.addAll(temp);
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort((a,b)->Integer.compare(a, b));

        //print output
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.size()).append('\n');
        for (Integer integer : list) {
            stringBuilder.append(integer).append(' ');
        }
        return stringBuilder.toString();
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