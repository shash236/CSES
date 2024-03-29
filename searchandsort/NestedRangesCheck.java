import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NestedRangesCheck {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = i;
        }

        int[][] ans = solve(n, arr);
        for (int[] is : ans) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : is) {
                stringBuilder.append(i).append(' ');
            }
            out.println(stringBuilder);
        }

        out.flush();
        out.close();
    }

    private static int[][] solve(int n, int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return -1 * Integer.compare(a[1], b[1]);
        });

        int prefixMax = Integer.MIN_VALUE;
        int suffixMin = Integer.MAX_VALUE;

        int[] contains = new int[n];
        int[] containedBy = new int[n];

        for (int i = 0; i < n; i++) {
            if (i > 0 && prefixMax >= ranges[i][1]) {
                containedBy[ranges[i][2]] = 1;
            }
            prefixMax = Math.max(prefixMax,ranges[i][1]);
        }

        for (int i = n-1; i >= 0; i--) {
            if(i < n - 1 && suffixMin <= ranges[i][1]) {
                contains[ranges[i][2]] = 1;
            }
            suffixMin = Math.min(suffixMin,ranges[i][1]);
        }

        return new int[][] { contains, containedBy };
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
                } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
