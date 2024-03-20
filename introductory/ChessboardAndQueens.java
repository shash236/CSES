import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessboardAndQueens {

    private static int count = 0;

    public static void main(String[] args) {
        int[][] grid = new int[8][8];
        FastReader scanner = new FastReader();
        for(int i = 0; i < 8; i++) {
            String gridRowString = scanner.nextLine();
            for(int j = 0; j < 8; j++){
                if(gridRowString.charAt(j)=='*'){
                    grid[i][j] = -1;
                }
            }
        }
        backtracking(0, grid, new int[8]);
        System.out.println(count);
    }

    private static void backtracking(int row, int[][] grid, int[] queens) {
        if(row == 8){
            count++;
            return;
        }
        int[] validPostions = new int[8];
        for(int i = 0; i < 8; i++) { validPostions[i] = grid[row][i]; }
        for(int x = 0; x < row; x++){
            int y = queens[x];
            int r = row - x;
            validPostions[y] = -1;
            if(y-r >= 0) validPostions[y-r] = -1;
            if(y+r < 8) validPostions[y+r] = -1;
        }
        for(int i = 0; i < 8; i++) {
            if(validPostions[i] == 0){
                queens[row] = i;
                backtracking(row+1, grid, queens);
                queens[row] = 0;
            }
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