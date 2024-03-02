
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = scanner.nextInt();
        List<String> graycodes = new ArrayList<>();
        graycodes.add("");
        for(int i = 1; i <= n; i++){
            int l = graycodes.size();
            List<String> newGrayCodes = new ArrayList<>();
            for(int j = 0; j < l; j++) {
                String prev = graycodes.get(j);
                graycodes.set(j,"0" + prev);
                newGrayCodes.add("1" + prev);
            }
            Collections.reverse(newGrayCodes);
            graycodes.addAll(newGrayCodes);
        }

        for (String string : graycodes) {
            out.println(string);
        }
        out.flush();
        out.close();
        scanner.close();
    }
}