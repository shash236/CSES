import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        // Scanner scanner = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++) { a[i] = scanner.nextInt(); }
        for(int i = 0; i < m; i++) { b[i] = scanner.nextInt(); }
        Arrays.sort(a);
        Arrays.sort(b);
        int apartmentsAssigned = 0;
        int p1 = 0; int p2 = 0;
        while(p1 < n && p2 < m){
            boolean isApartmentAcceptable = (k >= Math.abs(a[p1] - b[p2]));
            if(isApartmentAcceptable){
                p1++; p2++;
                apartmentsAssigned++;
            }else if(a[p1] > b[p2]){
                p2 = upperBound(b, a[p1] - k);
                // p2++;
            }else{
                p1 = upperBound(a, b[p2] - k);
                // p1++;
            }
        }
        out.println(apartmentsAssigned);
        out.flush();
        out.close();
        // scanner.close();
    }

    private static int upperBound(int[] a, int key) {
        int n = a.length;
        int s = 0; int e = n-1;
        int pos = n; // n happens in case when the largest number in a is less than key
        while(s <= e){
            int mid = s + (e - s)/2; // avoids overflow
            if(a[mid] < key){
                s = mid + 1;
            }else if(a[mid] > key){
                e = mid - 1;
                pos = mid;
            }else{
                pos = mid;
                e = mid - 1;
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