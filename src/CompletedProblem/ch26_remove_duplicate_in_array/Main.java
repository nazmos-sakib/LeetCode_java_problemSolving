package CompletedProblem.ch26_remove_duplicate_in_array;

public class Main {
    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
        int[] nums = {1,1,2}; // Input array
        int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length

        Solution s = new Solution();
        //int k = s.removeDuplicates(nums); // Calls your implementation
        int k = s.removeDuplicates(nums,1,1); // Calls your implementation

        System.out.println(k);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}

class Solution {
    public int removeDuplicates1(int[] nums) {
        //return removeDuplicates(nums,0,1);
        int newSize = 1; // Initialize the size of the new array with at least one element (the first element)

        // Iterate through the sorted array, skipping duplicates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[newSize] = nums[i]; // Shift non-duplicate element
                newSize++;
            }
        }
        return newSize;
    }
    public int removeDuplicates(int[] nums, int i, int newSize) {
        if (i< nums.length){
            if (nums[i] != nums[i - 1]) {
                nums[newSize] = nums[i]; // Shift non-duplicate element
                newSize = removeDuplicates(nums,i+1,newSize+1);
            } else {
                newSize = removeDuplicates(nums,i+1,newSize);
            }
        }
        return newSize;
    }

}