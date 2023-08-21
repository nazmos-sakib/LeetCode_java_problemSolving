package CompletedProblem.ch20_Valid_Parentheses;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Solution s = new Solution();

        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
    }
}

class Solution {
    public boolean isValid(String s) {


        Stack<Integer > opened = new Stack<>();
        Stack<String > firstBracket = new Stack<>();
        Stack<String > secondBracket = new Stack<>();
        Stack<String > thirdBracket = new Stack<>();

        for (char c:s.toCharArray()){
            //Process char
            if (c=='('){
                firstBracket.push(""+c);
                opened.push(1);
            }
            if (c==')') {
                if (!firstBracket.empty() && opened.pop()==1) {
                    firstBracket.pop();
                }
                else  return false;
            }

            if (c=='{'){
                secondBracket.push(""+c);
                opened.push(2);
            }
            if (c=='}'){
                if (!secondBracket.empty() && opened.pop()==2) {
                    secondBracket.pop();
                }
                else return false;

            }
            if (c=='['){
                thirdBracket.push(""+c);
                opened.push(3);
            }
            if (c==']'){
                if (!thirdBracket.empty() && opened.pop()==3) {
                    thirdBracket.pop();
                }
                else return false;
            }
        }

        if (firstBracket.empty() && secondBracket.empty() && thirdBracket.empty()) return true;
        else return false;
    }


}