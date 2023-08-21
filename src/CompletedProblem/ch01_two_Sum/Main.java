package CompletedProblem.ch01_two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        for (int i: s.twoSum(new int[]{2,7,11,15},9)){
            System.out.println(i);
        }
        for (int i: s.twoSum(new int[]{3,2,4},6)){
            System.out.println(i);
        }

        for (int i: s.twoSum(new int[]{3,3},6)){
            System.out.println(i);
        }

    }
}

class Solution {

    //Optimized Code
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }

    //Brute force
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }

        return new int[]{};
    }
}


/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

nums = [3,2,3]
target = 6
 */