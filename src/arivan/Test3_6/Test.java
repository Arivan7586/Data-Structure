package arivan.Test3_6;

public class Test {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution.ListNode pr1 = new Solution.ListNode(1);
        Solution.ListNode pr2 = new Solution.ListNode(2);
        pr1.next = pr2;
        pr2.next = null;

        Solution.ListNode p1 = new Solution.ListNode(1);
        Solution.ListNode p2 = new Solution.ListNode(2);
        Solution.ListNode p3 = new Solution.ListNode(2);
        Solution.ListNode p4 = new Solution.ListNode(1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;

        Solution.ListNode m1 = new Solution.ListNode(0);
        Solution.ListNode m2 = new Solution.ListNode(0);
        Solution.ListNode m3 = new Solution.ListNode(1);
        m1.next = m2;
        m2.next = m3;
        m3.next = null;

        //测试回文数方法
        Solution solution = new Solution();
//        solution.printNode(pr1);
//        System.out.println();
//        System.out.println(solution.isPalindrome(pr1));

        solution.printNode(m1);
        System.out.println();
        System.out.println(solution.isPalindrome(m1));


        //测试反转方法
//        solution.printNode(m1);
//        System.out.println();
//        Solution.ListNode newNode = solution.reverseList(m1);
//        solution.printNode(newNode);

        //测试比较方法
//        solution.printNode(m1);
//        System.out.println();
//        solution.printNode(pr1);
//        System.out.println();
//        System.out.println(solution.nodeIsSame(m1,pr1));
    }

}

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        //判断链表是否为回文链表
        if (head == null || head.next == null) {
            return true;
        }else {
            //找到中间节点
            ListNode newNode1 = findNode(head);
            //找到中间节点的下一个节点
            ListNode newNode2 = newNode1.next;
            newNode1.next = null;
            //反转中间节点的下一个节点
            ListNode now = reverseList(newNode2);

            //判断两个链表是否相同
            while (now != null) {
                if (now.val != head.val) {
                    return false;
                }
                now = now.next;
                head = head.next;
            }
            return true;
        }
    }
    public ListNode reverseList(ListNode head) {  //反转链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = dummyHead.next;
        ListNode s = f.next;
        while (s != null) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        return dummyHead.next;
    }
    public ListNode findNode(ListNode head) { //找到中间节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
    public void printNode(ListNode head) { //输出链表
        if (head == null) {
            System.out.println("当前链表为空！");
        }else {
            while (head != null) {
                System.out.print(head.val+" ");
                head = head.next;
            }
        }
    }
}

class Solution2 {
    //请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while(p.next.next != null) {
            p.val = p.next.val;
            p = p.next;
        }
        p.val = p.next.val;
        p.next = null;
    }
}