import java.util.Arrays;
import java.util.HashSet;

public class hash_APproblem {
    // 1st Approach
    // Expected Time Complexity : O(nLogn).
    // Expected Auxiliary Space : O(1)
    public static boolean checkIsAP(int arr[] ,int n){
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        for(int i=2;i<n;i++){
            if(arr[i]-arr[i-1]==diff){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    // 2nd Approach
    // Expected Time Complexity: O(n).
    // Expected Auxiliary Space: O(n)
    public static boolean checkIsAP1(int arr[] ,int n){
        // use HashSet
        HashSet<Integer> set = new HashSet<>();

        int max=Integer.MIN_VALUE; // -2147483648
        int min=Integer.MAX_VALUE; //  2147483647
        
        // Find min Max from given array
        for(int i=0;i<n;i++){
            set.add(arr[i]);
            max=Math.max(max, arr[i]);   // max = 12
            min=Math.min(min, arr[i]);   // min = 0
        }
        
        // diff between two element 
        int diff = (max-min)/(n-1);      // diff = (12-0)/(4-1) = 4

        // create count variable              0 12 4 8  
        int count=0; 
        // O(n)                    
        while (set.contains(max)) {      // True  max = 12 count = 1
            count++;                     // True  max = 08 count = 2
            max = max - diff;            // True  max = 04 count = 3
        }                                // True  max = 00 count = 4
        if (count == arr.length){
            return true;
        }
 
        return false;
    }
    public static void main(String[] args) {
        System.out.println("        Check Arithmetic Progression");
        int N=4;
        int arr[] = {0,12,4,8};
        // 1st Approach
        System.out.println(checkIsAP(arr, N));
        // 2nd Approach
        System.out.println(checkIsAP1(arr, N));
    }
}
