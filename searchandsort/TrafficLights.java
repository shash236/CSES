import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TrafficLights {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] ans = solve(x, n, arr);
        for (int a : ans) {
            out.println(a);
        }

        out.flush();
        out.close();
    }
    
    private static int[] solve(int x, int n, int[] arr) {
        LinkedList<Integer> positions = new LinkedList<>();
        positions.add(0);
        positions.add(x);
        for (Integer a : arr) {
            positions.add(a);
        }
        positions.sort((a,b)->Integer.compare(a, b));
    
        int[] ans = new int[n];
        int maxDiff = maxDiff(positions);
        for(int i = n-1; i >= 0; i--) {
            ans[i] = maxDiff;
            int pos = binarySearch(positions,arr[i]);
            positions.remove(pos);
            maxDiff = Math.max(maxDiff,positions.get(pos) - positions.get(pos-1));
        }

        return ans;
    }

    private static int maxDiff(LinkedList<Integer> linkedList){
        int maxVal = 0;
        for(int i = 1; i < linkedList.size(); i++) {
            maxVal = Math.max(linkedList.get(i) - linkedList.get(i-1), maxVal);
        }
        return maxVal;
    }

    private static int binarySearch(LinkedList<Integer> linkedList, int key) {
        int s = 0;
        int e = linkedList.size() - 1;
        int pos = -1;
        while(s <= e) {
            int m = s + (e - s)/2;
            int mVal = linkedList.get(m);
            if(mVal == key) {
                pos = m;
                break;
            }else if(mVal < key) {
                s = m + 1;
            }else {
                e = m - 1;
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
