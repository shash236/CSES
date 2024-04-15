import java.util.Scanner;

public class RemovingDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solve(scanner.nextInt()));
        scanner.close();
    }

    private static int solve(int n) {
        int count  = 0;
        while (n > 0) {
            n -= maxDigit(n);
            count++;
        }
        return count;
    }

    private static int maxDigit(int n) {
        int maxDigit = 0;
        while (n > 0) {
            maxDigit = Math.max(maxDigit,n%10);
            n /= 10;
        }
        return maxDigit;
    }
}
