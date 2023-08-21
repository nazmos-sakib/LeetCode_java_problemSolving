package CompletedProblem.ch13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("III"));
    }
}

class Solution {
    Map<Character,Integer>  romanValue = new HashMap<>();
    public Solution(){
        romanValue.put('I',1);
        romanValue.put('V',5);
        romanValue.put('X',10);
        romanValue.put('L',50);
        romanValue.put('C',100);
        romanValue.put('D',500);
        romanValue.put('M',1000);
    }
    public int romanToInt(String s) {
        int total_value=romanValue.get(s.charAt(s.length()-1));
        for (int i = s.length()-2;i>=0;i--){
            //System.out.println(i);
            //System.out.println(total_value);
            //int tem = map(s.charAt(i));
            int tem = romanValue.get (s.charAt(i));
            if(!superior(s.charAt(i),s.charAt(i+1))){
                total_value -= tem;
            }
            else total_value += tem;
        }
        return total_value;
    }

    public int map(char c){
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public boolean superior(char a, char b){

        //if (map(a)==map(b)) return true;
        //else if (map(a)>map(b)) return true;

        if (romanValue.get (a)==romanValue.get (b)) return true;
        else if (romanValue.get(a)>romanValue.get (b)) return true;
        return false;
    }
}