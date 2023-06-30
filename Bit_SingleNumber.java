// package Bit Manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Bit_SingleNumber {
    // Approach 1 O(n^2)
    public static int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            int index=-1;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                    index=j;
                }
            }
            if(count==1){
                return nums[index];
            }
        }
        return 0;
    }

    // Approach 2
    // Time complexity : O(n)
    // Space complexity : O(n)
    public static int singleNumber1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // System.out.println(map);
        for (int i : map.keySet()) {
            if(map.get(i)==1){
                return i;
            }
        }
        return 0;
    }

    // Approach 3 - using Sorting
    // Time complexity : O(nLog(n))
    // Space complexity : O(1)
    public static int singleNumber2(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i-1]  && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
    // Approach 4 using set
    // Time complexity : O(n)
    // Space complexity : O(k) --> k are unique numbers from array
    public static int singleNumber3(int nums[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }
        }
        int ans=0;
        for (Integer i : set) {
            ans=i;
        }
        return ans;
    }

    // Approach 4 using XOR
    // Time complexity : O(n)
    // Space complexity : O(1) 
    public static int singleNumber4(int nums[]){
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println("            Single Number");
        int nums[] = {4,1,2,1,4,3,2,3,9};
        // int nums[] = {4,1,2,1,2};
        // 1
        System.out.println(singleNumber(nums));
        // 2 
        System.out.println(singleNumber1(nums));
        // 3
        System.out.println(singleNumber2(nums));
        // 4
        System.out.println(singleNumber3(nums));
        // 5
        System.out.println(singleNumber4(nums));
    }
}
