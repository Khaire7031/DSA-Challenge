import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Kth_LargestNumber {

    // Approach 1
    // time Complexity O(n+k*(log(k)))
    // Space  Complexity O(k)

    public static int findKthLargest(int[] nums, int k) {
        // Create a Min Heap
        PriorityQueue<Integer> p = new PriorityQueue<>();//Comparator.reverseOrder()
        for(int i=0;i<nums.length;i++){

            // min heap of k size
            if( p.size() < k){
                p.add(nums[i]);
            }else if(p.peek() < nums[i]){
                p.remove();
                p.add(nums[i]);
            }
        }
        // return top element from PriorityQueue
        return p.peek();
    }

    // 2nd Approach
    // using Sorting 
    // time Cmplexity O(n*Log(n))
    // Space Complexity O(1)
    public static int findKthLargest1(int[] nums, int k) {
        // sort the array
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        System.out.println("          Kth Largest Element in an Array");
        int nums[]={3,2,1,5,6,4}, k = 1;
        // 1st Approach
        System.out.println(findKthLargest(nums, k));
        // 2nd Approach
        System.out.println(findKthLargest1(nums, k));
    }
}
