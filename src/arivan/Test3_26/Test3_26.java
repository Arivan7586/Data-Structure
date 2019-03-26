package arivan.Test3_26;

public class Test3_26 {
    public static void main(String[] args) {
        Solution.ListNode l1 = new Solution.ListNode(2);
        Solution.ListNode l2 = new Solution.ListNode(4);
        Solution.ListNode l3 = new Solution.ListNode(3);
        l1.next = l2;
        //l2.next = l3;
        Solution.ListNode p1 = new Solution.ListNode(5);
        Solution.ListNode p2 = new Solution.ListNode(6);
        Solution.ListNode p3 = new Solution.ListNode(4);
        p1.next = p2;
        p2.next = p3;
        Solution solution = new Solution();
        Solution.ListNode a = solution.addTwoNumbers(l1,p1);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}

class Solution {
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序
//    的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    public static class ListNode {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        int longer = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (true) {
            if ((t1 == null && t2 == null) || (t1 !=null && t2 == null)) {
                longer = 1;
                break;
            }else if (t1 == null && t2 != null) {
                longer = 2;
                break;
            }
            t1= t1.next;
            t2 = t2.next;
        }
        if (longer == 1) {
            dummyHead.next = l1;
        }else {
            dummyHead.next = l2;
            l2 = l1;
        }
        ListNode temp = dummyHead.next;
        int value = 0;
        while (temp != null) {
            if (l2 != null) {
                int sum = value + temp.val + l2.val;
                if (sum >= 10) {
                    temp.val = sum % 10;
                    value = 1;
                }else {
                    temp.val = sum;
                    value = 0;
                }
                l2 = l2.next;
            }else {
                int sum = value + temp.val;
                if (sum >= 10) {
                    temp.val = sum % 10;
                    value = 1;
                }else {
                    temp.val = sum;
                    value = 0;
                }
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (value == 1) {
            ListNode newNode = new ListNode(value);
            temp.next = newNode;
        }
        return dummyHead.next;

//        if (l1 == null) {
//            return l2;
//        }else if (l2 == null) {
//            return l1;
//        }
//        int m = nodenumber(l1);
//        int n = nodenumber(l2);
//        ListNode dummyHead = new ListNode(-1);
//
//        if (m >= n) {
//            dummyHead.next = l1;
//        }else {
//            dummyHead.next = l2;
//            l2 = l1;
//        }
//        ListNode temp = dummyHead.next;
//        int value = 0;
//        while (temp != null) {
//            if (l2 != null) {
//                int sum = value + temp.val + l2.val;
//                if (sum >= 10) {
//                    temp.val = sum % 10;
//                    value = 1;
//                }else {
//                    temp.val = sum;
//                    value = 0;
//                }
//                l2 = l2.next;
//            }else {
//                int sum = value + temp.val;
//                if (sum >= 10) {
//                    temp.val = sum % 10;
//                    value = 1;
//                }else {
//                    temp.val = sum;
//                    value = 0;
//                }
//            }
//            if (temp.next == null) {
//                break;
//            }
//            temp = temp.next;
//        }
//        if (value == 1) {
//            ListNode newNode = new ListNode(value);
//            temp.next = newNode;
//        }
//        return dummyHead.next;
    }
    public int nodenumber(ListNode node) {
        ListNode temp = node;
        int sum = 0;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        return sum;
    }
}

class Solution1 {
//    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//    你应当保留两个分区中每个节点的初始相对位置
    public static class ListNode {
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode1 = new ListNode(-1);
        ListNode newNode2 = new ListNode(-1);
        ListNode temp1 = newNode1;
        ListNode temp2 = newNode2;
        while (head != null) {
            if (head.val < x) {
                temp1.next = new ListNode(head.val);
                temp1 = temp1.next;
            }else {
                temp2.next = new ListNode(head.val);
                temp2 = temp2.next;
            }

            head = head.next;
        }
        temp1.next = newNode2.next;
        return newNode1.next;
    }
}