import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConcertTickets {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> prices = new ArrayList<>();
        int[] queries = new int[m];
        for(int i = 0; i < n; i++) {
            prices.add(scanner.nextInt());
        }
        for(int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }
        prices.sort((a,b)->Integer.compare(a, b));

        for(int i = 0; i < m; i++){
            int position = solve(queries[i], prices);
            out.println(position!=-1 ? prices.get(position) : -1);
            if(position!=-1){
                prices.remove(position);
            }
        }

        out.flush();
        out.close();
    }

    private static int solve(int number, List<Integer>arr) {
        int start = 0;
        int end = arr.size()-1;
        int position = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int val = arr.get(mid);
            if(val == number){
                position = mid;
                break;
            }else if(val < number){
                position = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return position;
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
