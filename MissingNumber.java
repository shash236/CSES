import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner scanner = new Scanner(new File("input.txt"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long totalSum = ((long)n * (1 + n))/2;
        for(int i = 0; i < n-1; i++){
            totalSum -= scanner.nextInt();
        }
        System.out.println(totalSum);
        scanner.close();
    }
}
