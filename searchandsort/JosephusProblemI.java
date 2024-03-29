import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JosephusProblemI {
    
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[] ans = solve(n);
        for (int a : ans) {
            out.println(a);
        }
        
        out.flush();
        out.close();
    }

    private static int[] solve(int n) {
        Node head = null;
        Node prev = null;
        for(int i = 1; i <= n; i++) {
            Node curr = new Node(i, prev, null);
            if(prev!=null) { prev.next = curr; }
            else { head = curr; }
            prev = curr;
        }
        prev.next = head;
        head.prev = prev;
        
        int[] ans = new int[n];
        Node curr = head;
        for(int i = 0; i < n; i++) {
            Node removed = curr.next;
            ans[i] = removed.val;
            removed.prev.next = removed.next;
            removed.next.prev = removed.prev;
            curr = removed.next;
        }

        return ans;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
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
