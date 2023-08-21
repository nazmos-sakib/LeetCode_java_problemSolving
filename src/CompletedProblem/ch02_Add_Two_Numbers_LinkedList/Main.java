package CompletedProblem.ch02_Add_Two_Numbers_LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        //[9,9,9,9,9,9,9]
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l_2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        //l1 = [2,4,3] implementation
        ListNode l3= new ListNode(3);
        ListNode l4= new ListNode(4,l3);
        ListNode l2= new ListNode(2,l4);

        // l2 = [5,6,4]
        ListNode l_4= new ListNode(4);
        ListNode l6= new ListNode(6,l_4);
        ListNode l5= new ListNode(5,l6);

         */


        Solution s = new Solution();

        //ListNode l1 = s.createListNode(new int[]{9,9,9,9,9,9,9});
        //ListNode l2 = s.createListNode(new int[]{9,9,9,9});

        ListNode l1 = createListNode(new int[]{9});
        ListNode l2 = createListNode(new int[]{1,9,9,9,9,9,9,9,9,9});

        //l1 =[9]
        //l2 =[1,9,9,9,9,9,9,9,9,9]
        //s.addTwoNumbers(l2,l5);
        s.addTwoNumbers(l1,l2);

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
            } else {
                reminder =  0;
                l.val = (temp);
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