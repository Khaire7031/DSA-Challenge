
import java.util.*;
public class RotateArray {
    // 1st approach
    // time complexity O(n*k)
    public static void rotate1(int[] arr, int k) {
        for(int i=0;i<k;i++){
            int temp=arr[arr.length-1];
            for(int j=arr.length-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=temp;
        }
        print(arr);
    }
    // 2nd approach
    // time complexity O(n) space O(n)
    public static void rotate2(int[] arr, int k) {
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            alist.add(arr[i]);
        }
        int i=0,l=k;
        while(k>arr.length){
            k=k-arr.length;
        }
        while(l-- >0){
            int j=(arr.length-k+i)%alist.size();
            arr[i++]=alist.get(j);
            i=i%arr.length;
        }
    }
    // 3rd approach
    // time complexity O(n) space O(1)
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        print(arr);
    }
    public static void reverse(int[] arr,int s,int e){
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public static void print(int arr[]){
        System.out.println("----------------------------------");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n----------------------------------");
    }
    public static void main(String[] args) {
        System.out.println("        Rotate Array");
        int  nums[] = {1,2,3,4,5,6,7}, k = 3;
        // int  nums[] = {-1,-100,3,99}, k = 2;
        // int nums[]={1,2},k=3;
        rotate(nums, k);
    }
}
