package arivan.Test3_14;

public class Test3_14 {
    public static void main(String[] args) {
        Solution.ListNode p1 = new Solution.ListNode(1);
        Solution.ListNode p2 = new Solution.ListNode(2);
        Solution.ListNode p3 = new Solution.ListNode(3);
        Solution.ListNode p4 = new Solution.ListNode(4);
        Solution.ListNode p5 = new Solution.ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        Solution.printNode(p1);
        System.out.println();

        Solution.ListNode node = Solution.reverseBetween2(p1,2,5);
        //Solution.ListNode node = Solution.reverseNode(p1);
        Solution.printNode(node);
    }
}

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void printNode(ListNode node) {
        if (node == null) {
            System.out.println("当前链表为空！");
            return;
        }
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

//    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//    说明:
//            1 ≤ m ≤ n ≤ 链表长度。
//    示例:
//    输入: 1->2->3->4->5->NULL, m = 2, n = 4
//    输出: 1->4->3->2->5->NULL
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode t = head;
        while (t != null) {
            count++;
            t = t.next;
        }
        ListNode dummyHead = head;
        if (m == 1 && n == count) {
            return reverseNode(head);
        }else if (m == 1 && n < count) {
            //找到需要反转的链表的尾节点
            ListNode temp = dummyHead;
            for (int i = 0; i < n-m; i++) {
                temp = temp.next;
            }
            //找到右边不需要反转的链表的头节点
            ListNode secondHead = temp.next;
            temp.next = null;
            dummyHead = reverseNode(dummyHead);
            //找到反转后链表的尾节点
            ListNode newNode = dummyHead;
            while (newNode != null) {
                if (newNode.next == null) {
                    break;
                }
                newNode = newNode.next;
            }
            newNode.next = secondHead;
            return dummyHead;
        }else if (m > 1 && n == count) {
            ListNode firstTailNode = dummyHead;
            for (int i = 1; i < m-1; i++) {
                firstTailNode = firstTailNode.next;
            }
            //找到需要反转的链表的头节点
            ListNode reverseHead = firstTailNode.next;
            firstTailNode.next = null;
            reverseHead = reverseNode(reverseHead);
            firstTailNode.next = reverseHead;
            return head;
        }else {
            //找到左边不用反转的链表的尾节点firstTailNode。
            ListNode firstTailNode = dummyHead;
            for (int i = 1; i < m-1; i++) {
                firstTailNode = firstTailNode.next;
            }
            //找到需要反转的链表的头节点
            ListNode reverseHead = firstTailNode.next;
            firstTailNode.next = null;
            ListNode temp = reverseHead;
            //找到需要反转的链表的尾节点
            for (int i = 0; i < n-m; i++) {
                temp = temp.next;
            }
            //如果需要反转的链表的尾节点是整个链表的尾节点
            if (temp.next == null) {
                reverseHead = reverseNode(reverseHead);
                firstTailNode.next = reverseHead;
                return head;
            }else {
                //找到右边不用反转的链表的头节点
                ListNode secondHead = temp.next;
                temp.next = null;
                reverseHead = reverseNode(reverseHead);
                //找到反转后链表的尾节点
                ListNode newNode = reverseHead;
                while (reverseHead != null) {
                    if (reverseHead.next == null) {
                        break;
                    }
                    reverseHead = reverseHead.next;
                }
                //反转后的链表接上后面的链表
                reverseHead.next = secondHead;
                //前面的链表接上反转后的链表
                firstTailNode.next = newNode;
                return head;
            }
        }
    }

    public static ListNode reverseNode(ListNode head) { //反转全部链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = head;
        ListNode s = f.next;
        while (s != null) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        return dummyHead.next;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //temp始终为需要反转的链表头节点的上一个节点
        ListNode temp  = dummyHead;
        int i = 1;
        while (i < m) {
            temp = temp.next;
            i++;
        }
        //找到需要反转的链表的头节点f
        ListNode f = temp.next;
        //找到需要反转的链表的第二个节点s
        ListNode s = f.next;
        while (i < n && s != null) {
            //第一个节点的下一个指向第三个节点
            f.next = s.next;
            //第二个节点的下一个指向第一个节点（temp.next始终为第一个节点）
            s.next = temp.next;
            //把第二个节点变为第一个节点
            temp.next = s;
            //将s变为f的下一个节点（s始终为f的下一个节点）
            s = f.next;
            i++;
        }
        return dummyHead.next;
    }
}