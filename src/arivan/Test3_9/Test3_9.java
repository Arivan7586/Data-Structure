package arivan.Test3_9;

public class Test3_9 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }
}


class Solution {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    //编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int num1 = nodeNumbers(tempA);
        int num2 = nodeNumbers(tempB);
        if (num1 > num2) {
            tempA = run(tempA,num1-num2);
        }else if (num1 < num2) {
            tempB = run(tempB,num2-num1);
        }
        while (tempA != null && tempB != null){
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    public int nodeNumbers(ListNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        ListNode temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode run(ListNode node, int num) {
        if (num > nodeNumbers(node) || num < 0) {
            return null;
        }
        if (node == null) {
            return node;
        }
        ListNode temp = node;
        for (int i = 0; i < num; i++) {
            temp = temp.next;
        }
        return temp;
    }
}

class Solution1 {
    //给定一个链表，判断链表中是否有环。
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow != null) {
            if (fast == null || fast.next ==null) {
                return false;
            }
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}