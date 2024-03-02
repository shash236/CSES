
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromeReorder {
    
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String s = scanner.next();
        int[] charCountArray = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            charCountArray[s.charAt(i) - 'A']++;
        }

        out.println(isPalindromePossible(charCountArray, s.length()) ? 
           createPalindrome(charCountArray, s.length()) : "NO SOLUTION");

        out.flush();
        out.close();
    }

    private static boolean isPalindromePossible(int[] charCountArray, int lengthOfString) {
        int oddCountChars = 0;
        //iterating over all characters
        for(int i = 0; i < 26; i++) {
            if(charCountArray[i]%2==1){
                oddCountChars++;
            }
        }

        if(oddCountChars > 1) return false;
        else return true;

    }

    public static String createPalindrome(int[] charCountArray, int lengthOfString) {
        int oddCountChar = 0; 
        int[] charArray = new int[lengthOfString];
        int s = 0; int e = lengthOfString - 1;
        for(int i = 0; i < 26; i++) {
            if(charCountArray[i]%2 == 1) {
                oddCountChar = i;
                charCountArray[i]--;
            }
            for(int j = 0; j < charCountArray[i]; j+=2){
                charArray[s] = i; s++;
                charArray[e] = i; e--;    
            }
        }

        if(lengthOfString%2 == 1) { charArray[s] = oddCountChar; }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : charArray) {
            stringBuilder.append((char)(i+'A'));
        }

        return stringBuilder.toString();

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
