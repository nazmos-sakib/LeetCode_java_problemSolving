package CompletedProblem.ch203_Remove_Linked_List_Elements;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        Solution s = new Solution();

        //ListNode l1 = s.createListNode(new int[]{9,9,9,9,9,9,9});
        //ListNode l2 = s.createListNode(new int[]{9,9,9,9});

        ListNode l1 = createListNode(new int[]{9});
        ListNode l2 = createListNode(new int[]{1,9,9,9,9,9,9,9,9,9});



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
    public ListNode removeElements1(ListNode head, int val) {
        ListNode result = new ListNode();
        ListNode resultHead = result;
        while (head!=null){
            if (head.val!=val){
                result.next = head;
            }
        }
        return resultHead.next;
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head!=null){
            head.next = removeElements(head.next,val);
            if (head.val==val){
                return head.next;
            } else return head;
        }
        return null;
    }


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


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}