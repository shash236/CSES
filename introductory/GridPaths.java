import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GridPaths {

    private static int count = 0;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        String path = scanner.next();
        int[][] grid = new int[7][7];
        grid[6][0] = 1;
        backtracking(0, path, 0, 0, grid);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.println(count);
        out.flush();
        out.close();
    }
    
    private static void backtracking(int p, String path, int x, int y, int[][] grid) {
        if(p == 48 && x==6 && y==0){
            count++;
            return;
        }
        boolean isValidPostion = (x >= 0 && x < 7) && (y>=0 && y < 7) && (grid[x][y] == 0);
        if(!isValidPostion) return;
        grid[x][y] = 1;
        Character direction = path.charAt(p);
        if(direction!='?'){
            if(direction == 'D') backtracking(p+1, path, x+1, y, grid);
            if(direction == 'U') backtracking(p+1, path, x-1, y, grid);
            if(direction == 'R') backtracking(p+1, path, x, y+1, grid);
            if(direction == 'L') backtracking(p+1, path, x, y-1, grid);
            
        }else{
            backtracking(p+1, path, x+1, y, grid);
            backtracking(p+1, path, x-1, y, grid);
            backtracking(p+1, path, x, y+1, grid);
            backtracking(p+1, path, x, y-1, grid);
        }
        grid[x][y] = 0;
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