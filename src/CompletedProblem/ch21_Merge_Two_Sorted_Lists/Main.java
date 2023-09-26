package CompletedProblem.ch21_Merge_Two_Sorted_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        //ListNode l1 = s.createListNode(new int[]{9,9,9,9,9,9,9});
        //ListNode l2 = s.createListNode(new int[]{9,9,9,9});

        ListNode l1 = createListNode(new int[]{1,2,4});
        ListNode l2 = createListNode(new int[]{1,3,4});

        //ListNode l1 = createListNode(new int[]{});
        //ListNode l2 = createListNode(new int[]{});

        //ListNode l1 = createListNode(new int[]{});
        //ListNode l2 = createListNode(new int[]{0});

        //printListNode(l1);
        //printListNode(l2);
        printListNode(s.mergeTwoLists(l2,l1));
        //s.mergeTwoLists(l2,l1);
/*
        ListNode a = new ListNode();
        System.out.println(a.val);*/


    }

    public static void printListNode(ListNode n){
        System.out.println("------------------");
        while(true) {
            System.out.print("-"+n.val);
            if (n.next!=null){
                n = n.next;
            } else break;
        }
        System.out.println("");
    }

    public static ListNode createListNode(int[] nums){
        //System.out.println(nums.length);
        if (nums.length==0) return new ListNode();
        if (nums.length>1){
            return  new ListNode(nums[0],createListNode(Arrays.copyOfRange(nums,1,nums.length)));
        }
        return new ListNode(nums[0]);
    }
}

class Solution {
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //1: which first value is small
        //forward startList, when first is bigger then second

        ListNode previous = new ListNode();
        ListNode result = new ListNode(-2,previous) ;

        //ListNode startList = (list1.val>=list2.val)? list2:list1;
        //ListNode marge = (list1.val<list2.val)? list1:list2;

        while (true){
            if (list1!=null && list2!=null){
                ListNode ll = new ListNode();
                if (list1.val<= list2.val ){
                    //System.out.println(list1.val);
                    ll.val = list1.val;
                    previous.next = ll;
                    previous= previous.next;

                    if (list1.next!=null) list1 = list1.next ;
                    else break;
                } else {
                    while (list2.next!=null && list1.val> list2.val){
                        ListNode lll = new ListNode();
                        //System.out.println(list2.val);
                        lll.val= list2.val;
                        previous.next = lll;
                        previous= previous.next;


                        list2 = list2.next;
                    }
                }
            }
        }

        return result.next.next;

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        //System.out.println(list1);
        ArrayList<Integer> l1 = new ArrayList<>();
        while (list1!=null){
            l1.add(list1.val);
            list1 = list1.next;
        }

        while (list2!=null){
            l1.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(l1);

        ListNode result = new ListNode() ;
        ListNode l = result;
        for (int i:l1) {
            l.next = new ListNode(i);
            l = l.next;
        }

        return result.next;
    }

    //simple Java ✅ || Runtime 1 ms✅ || Beats 100% ✅
    public ListNode mergeTwoListsGoodSolution(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }

}


class ListNode {
    int val;
    ListNode next;
    //ListNode() {val= Integer.parseInt(null);}
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}