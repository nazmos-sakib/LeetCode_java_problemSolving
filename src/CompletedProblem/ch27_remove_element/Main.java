package CompletedProblem.ch27_remove_element;

public class Main {
    public static void main(String[] args){

        //int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
        int[] nums = {3,2,2,3}; // Input array
        int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length

        Solution s = new Solution();

        int k = s.removeElement(nums, 3); // Calls your implementation

        assert k == expectedNums.length;
        //sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int newSize = 0;
        if(nums.length!=0){

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[newSize] = nums[i]; // Shift non-duplicate element
                    newSize++;
                }
            }
        }
        return newSize;

    }
}