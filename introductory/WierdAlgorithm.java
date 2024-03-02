
import java.util.Scanner;

/*
 * Its about learning to be careful about overflows
 */

public class WierdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = (long)scanner.nextInt();
        while (true) {
            System.out.print(n + " ");
            if (n == 1)
                break;
            else if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        System.out.println();
        scanner.close();
    }
}