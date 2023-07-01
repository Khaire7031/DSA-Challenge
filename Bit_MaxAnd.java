import java.util.Arrays;

public class Bit_MaxAnd {
    // Approach 1 
    // Time complexity O(n^2)
    public static int maxAND (int arr[], int N) {
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int and = arr[i]&arr[j];
                max=Math.max(max, and);
            }
        }
        return max;
    }
    // Approach 2 
    // Time complexity O(nlog(n)) --> not applicable for all input
    public static int maxAND1(int arr[], int N) {
        int max=0;
        Arrays.sort(arr);
        for(int i=1;i<N;i++){
            int and = arr[i]&arr[i-1];
            max=Math.max(max, and);
        }
        return max;
    }
    // Approach 3
    // Time complexity O(n^2)
    public static int maxAND2(int arr[], int N) {
        int ans=0;
        for(int i=32;i>=0;i--){
            int ct = getCount((ans|(1<<i)),arr,N);
            if(ct>=2){
                ans=ans|(1<<i);
            }
        }
        return ans;
    }
    public static int getCount(int ans,int arr[],int n){
        int ct =0;
        for(int i=0;i<n;i++){
            if((arr[i]&ans)==ans){
                ct++;
            }
        }
        return ct;
    }
    public static void main(String[] args) {
        System.out.println("            Maximum AND Value");
        int N = 4;
        int arr[] = {4, 8, 12, 16};
        System.out.println(maxAND(arr, N));
        System.out.println(maxAND1(arr, N));
        System.out.println(maxAND2(arr, N));
    }
}
