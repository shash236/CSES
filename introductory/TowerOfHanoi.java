
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        List<String> results = new ArrayList<>();
        solve(1, 2, 3, n, results);

        out.println(results.size());
        for (String string : results) {
            out.println(string);
        }
        out.flush();
        out.close();
        scanner.close();
    }

    private static void solve(int start, int middle, int end, int count, List<String> results) {
        if(count <= 0) return;
        if (count == 1){
            results.add(start + " " + end);
            return;
        }
        solve(start, end, middle, count-1, results);
        results.add(start + " " + end);
        solve(middle, start, end, count-1, results);
    }
}
