package utils;

public class Utils {
    private Utils(){}

    private static int upperBound(int[] a, int key) {
        int n = a.length;
        int s = 0; int e = n-1;
        int pos = n; // n happens in case when the largest number in a is less than key
        while(s <= e){
            int mid = s + (e - s)/2; // avoids overflow
            if(a[mid] < key){
                s = mid + 1;
            }else if(a[mid] > key){
                e = mid - 1;
                pos = mid;
            }else{
                pos = mid;
                s = mid + 1;
            }
        }
        return pos;
    }
}
