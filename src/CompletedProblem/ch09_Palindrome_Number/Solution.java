package CompletedProblem.ch09_Palindrome_Number;



public class Solution {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Solution s = new Solution();
        System.out.println(s.isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {

        String str = Integer.toString(x);
        return str.equals(String.valueOf(new StringBuilder(str).reverse()));
    }
}



