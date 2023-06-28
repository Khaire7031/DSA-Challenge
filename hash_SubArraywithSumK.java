import java.util.HashMap;

public class hash_SubArraywithSumK{
    // 1st Apporach
    // nive solution 
    // time complexity O(n^2)
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    ans++;
                    // break;
                }
            }
        }
        return ans;
    }

    // 2nd approach using HashMap
    public static int subarraySum1(int[] nums, int k) {
        int ans = 0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("            Subarray Sum Equals K");
        // int arr[]={1,1,1}; // ans 2
        int arr[]={1,2,3}; // ans 2
        int k=3;
        // 1st Apporach
        System.out.println(subarraySum(arr, k));
        // 2nd Apporach
        System.out.println(subarraySum1(arr, k));
    }
}