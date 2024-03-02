import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 1000000007;
        System.out.println(modPower(2, n, m));
        scanner.close();
    }

    public static int modPower(int x, int n, int m){
        if(n == 0) return 1;
        else if(n % 2 == 0) {
            int u = modPower(x, n/2, m);
            return (int)(((long)u*u)%m);
        }else {
            return (modPower(x, n-1, m) * x)%m;
        }
    }
}
