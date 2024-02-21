import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Repititions {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner scanner = new Scanner(new File("input.txt"));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int maxRepitition = 1;
        int currentRepitition = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                currentRepitition++;
            }else{
                maxRepitition = Math.max(currentRepitition,maxRepitition);
                currentRepitition = 1;
            }
        }
        maxRepitition = Math.max(currentRepitition,maxRepitition);
        System.out.println(maxRepitition);
        scanner.close();
    }
}