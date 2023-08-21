package CompletedProblem.ch14_Longest_Common_Prefix;

public class Solution {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Solution s = new Solution();
        System.out.println("-"+s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("-"+s.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println("-"+s.longestCommonPrefix(new String[]{"dog"}));
        System.out.println("-"+s.longestCommonPrefix(new String[]{"acc","aaa","aaba"}));
    }

    public String longestCommonPrefix(String[] strs) {
        //System.out.println("-------------------------------");
        String result = strs[0];
        for (int i=0;i<strs.length-1;i++){
            String temp = getSamePrefix(strs[i],strs[i+1]);
            if (!temp.equals("")){
                //result = temp;
                //System.out.println("-"+result);
                //System.out.println("-t"+temp);
                result = getSamePrefix(result,temp);
            } else return "";
        }
        return result;
    }

    String getSamePrefix(String s1, String s2){
        String temp="";
        for (int i=0;i<Math.min(s1.length(),s2.length());i++){
            if (s1.charAt(i)==s2.charAt(i)){
                temp += s1.charAt(i);
            } else return temp;
        }
        return temp;
    }

}