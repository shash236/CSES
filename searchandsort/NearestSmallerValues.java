import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NearestSmallerValues {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] ans = solve(n, arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int a : ans) {
            stringBuilder.append(a).append(' ');
        }
        out.println(stringBuilder);
        out.flush();
        out.close();
    }

    private static int[] solve(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.empty()) {
                answer[i] = 0;
                stack.push(i);
            }
            else{
                answer[i] = stack.peek() + 1;
                stack.add(i);
            }
        }
        return answer;
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