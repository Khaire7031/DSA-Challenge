import java.util.*;
public class SquareOfArray {
    // 1st approach
    // time complexity O(nLon(n)+n)
    public int[] sortedSquares1(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }
    // 2nd approach
    // time complexity O(n) space : O(n)
    public static int[] sortedSquares(int[] nums) {
        int pt1 = 0;
        int pt2 = nums.length -1;
        int n = nums.length -1;

        int result[] = new int[n+1];

        while(pt1 <= pt2){
            int a = (int)Math.pow(nums[pt1],2);
            int b = (int)Math.pow(nums[pt2],2);
            if(a > b){
                result[n] = a;
                pt1++;
            }else{
                result[n] = b;
                pt2--;;
            }

            n--;
        } 
        print(result);
        return result;
    }
    public static void print(int arr[]){
        System.out.println("----------------------------------");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n----------------------------------");
    }
    public static void main(String[] args) {
        System.out.println("            ");
        int nums[] = {-4,-1,0,3,10};
        sortedSquares(nums);
    }
}
