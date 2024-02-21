import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner scanner = new Scanner(new File("input.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long minNumOfMoves = 0;
        int prevNum = scanner.nextInt();
        for(int i = 1; i < n; i++) {
            int num = scanner.nextInt();
            if(num < prevNum) {
                minNumOfMoves += (prevNum - num);
                num = prevNum;
            }
            prevNum = num;
        }
        System.out.println(minNumOfMoves);
        scanner.close();
    }
}
