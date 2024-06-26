import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Utils {
    private Utils(){}

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(upperBound(arr,6));
    }
    
    // smallest number in a sorted array that is greater than key
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
                s = mid + 1;
            }
        }
        return pos;
    }

    // faster mod of  x^n % m;
    public static int modPower(int x, int n, int m){
        if(n == 0) return 1;
        else if(n % 2 == 0) {
            int u = modPower(x, n/2, m);
            return (int)(((long)u*u)%m);
        }else {
            return (modPower(x, n-1, m) * x)%m;
        }
    }

    // fast reader
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
