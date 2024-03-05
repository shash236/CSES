import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CreatingStrings {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        // Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String s = scanner.next();
        s = sortString(s);
        List<String> result = new ArrayList<>();
        generatePermutations("", s, s.length(), 0, new HashSet<>(), result);
        Set<String> existing = new HashSet<>(result);
        out.println(existing.size());
        for (String string : result) {
            if(!existing.contains(string)) continue;
            out.println(string);
            existing.remove(string);
        }
        out.flush();
        out.close();
        // scanner.close();
    }

    private static void generatePermutations(String curr, String s, int n, int len, Set<Integer> picked, List<String> result) {
        if(len == n){
            result.add(curr);
            return;
        }
        for(int i = 0; i < n; i++){
            if(picked.contains(i)) continue;
            picked.add(i);
            generatePermutations(curr + s.charAt(i), s, n, len+1, picked, result);
            picked.remove(i);
        }
    }

    private static String sortString(String s){
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        return new String(cArr);
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
