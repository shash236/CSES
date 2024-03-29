import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Towers {

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
    
    private static int solve(int n, int[] arr) {
        List<Integer> towers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int towerNum = upperBound(towers, arr[i]);
            if(towerNum == towers.size()){
                towers.add(arr[i]);
            }else{
                towers.set(towerNum,arr[i]);
            }
        }
        return towers.size();
    }

    private static int upperBound(List<Integer> a, int key) {
        int n = a.size();
        int s = 0; int e = n-1;
        int pos = n; // n happens in case when the largest number in a is less than key
        while(s <= e){
            int mid = s + (e - s)/2; // avoids overflow
            if(a.get(mid) < key){
                s = mid + 1;
            }else if(a.get(mid) > key){
                e = mid - 1;
                pos = mid;
            }else{
                s = mid + 1;
            }
        }
        return pos;
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
