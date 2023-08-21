package DifferentApproach.ch02_Add_Two_Numbers_LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Solution s = new Solution();


        //s.addTwoNumbers(l2,l5);
        //s.addTwoNumbers();

        //ListNode l2 = createListNode(new int[]{9});
        //ListNode l1 = createListNode(new int[]{1,9,9,9,9,9,9,9,9,9});

        ListNode l2 = createListNode(new int[]{8,3,2});
        ListNode l1 = createListNode(new int[]{9,2,1});

       ListNode n = s.addTwoNumbers(l2,l1);

       while(true) {
            System.out.println("-"+n.val);
            if (n.next!=null){
                n = n.next;
            } else break;
        }


    }

    public static ListNode createListNode(int[] nums){
        //System.out.println(nums.length);
        if (nums.length>1){
            return  new ListNode(nums[0],createListNode(Arrays.copyOfRange(nums,1,nums.length)));
        }
        return new ListNode(nums[0]);
    }

}




class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        * step1: compare size
        * step2:
        * */


        ArrayList <Integer> result = new ArrayList<>();

        int reminder=0;
        int a1= 0;
        int a2=0;


        ListNode previous = new ListNode();
        ListNode ll = new ListNode();
        ll.next = previous;
        boolean l1EndTracer = false;
        boolean l2EndTracer = false;

        while (true){

            ListNode l = new ListNode();

            a1 = l1.val;
            a2 = l2.val;
            System.out.println(a1+"-"+a2+"-"+reminder);
            int temp = a1 + a2 + reminder;
            if(temp>=10) {
                reminder =  1;
                l.val = (temp - 10);
                result.add(temp - 10);
            } else {
                reminder =  0;
                l.val = (temp);
                result.add(temp);
            }
            previous.next = l;
            previous = l;

            if (l1.next!=null){
                l1 = l1.next;
            } else {
                l1.val = 0;
                l1EndTracer = true;
            }

            if (l2.next!=null){
                l2 = l2.next;
            } else {
                l2.val = 0;
                l2EndTracer = true;
            }


            if (l1.next==null && l2.next==null && reminder==0 && l1EndTracer && l2EndTracer) {
                break;
            }

        }

        System.out.println(result);

        ListNode l = new ListNode(result.get(result.size()-1));

        for (int i=result.size()-2;i>-1;i--){
             l = new ListNode(result.get(i),l);
        }


        //return Main.createListNode(result.stream().mapToInt(i->i).toArray());

        return ll.next.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */