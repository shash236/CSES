import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int numberOfZeros = 0;
        int multiplesOf5 = 5;

        while(n/multiplesOf5 > 0){
            numberOfZeros += (n/multiplesOf5);
            multiplesOf5 *= 5;
        }

        System.out.println(numberOfZeros);

        scanner.close();
    }
}
