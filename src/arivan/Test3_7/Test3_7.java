package arivan.Test3_7;

public class Test3_7 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Solution.ListNode l1 = new Solution.ListNode(1);
        Solution.ListNode l2 = new Solution.ListNode(2);
        Solution.ListNode l3 = new Solution.ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        Solution.ListNode m1 = new Solution.ListNode(1);
        Solution.ListNode m2 = new Solution.ListNode(3);
        Solution.ListNode m3 = new Solution.ListNode(4);
        m1.next = m2;
        m2.next = m3;
        m3.next = null;

        Solution solution = new Solution();
        //测试拼接方法
//        Solution.ListNode prin = solution.addNode(l1,m1);
//        solution.print(prin);
        System.out.println();

        //测试排序方法
//        solution.sortNodes(prin);
//        solution.print(prin);

        Solution.ListNode pp = solution.mergeTwoLists(l1,m1);
        solution.print(pp);
    }
}


class Solution {
    //将两个有序链表合并为一个新的有序链表并返回。
    // 新链表是通过拼接给定的两个链表的所有节点组成的。
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }else if (l2 == null && l1 != null) {
            return l1;
        }else if (l1 == null && l2 == null) {
            return l1;
        }
        //拼接链表
        ListNode newNode = addNode(l1,l2);
        //给新链表排序
        ListNode ret = sortNodes(newNode);
        return ret;
    }
    public ListNode sortNodes(ListNode head) {
        //给链表排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (head != null) {
            ListNode nextNode = head.next;
            ListNode nowNode = head;
            while (nextNode != null) {
                if (nowNode.val > nextNode.val) {
                    int temp = nowNode.val;
                    nowNode.val = nextNode.val;
                    nextNode.val = temp;
                }
                nextNode = nextNode.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
    public ListNode addNode(ListNode l1, ListNode l2) { //拼接两个链表
        if (l1 == null && l2 != null) {
            return l2;
        }else if (l2 == null && l1 != null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = l1;
        //先找到链表1的最后一个节点
        while (l1.next != null) {
            l1 = l1.next;
        }
        //将链表1的最后一个节点指向链表2的头节点
        l1.next = l2;
        return dummyHead.next;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

}