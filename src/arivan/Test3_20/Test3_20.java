package arivan.Test3_20;

import java.util.Arrays;

public class Test3_20 {
    private static class ListNode {
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
    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

//        printNode(p1);
//        Test3_20 t = new Test3_20();
//        t.reorderList(p1);
//        printNode(p1);

        int[] arr = new int[]{5,6,1,9,2,7};
        Arrays.sort(arr);
        for (int i: arr) {
            System.out.print(i+" ");
        }
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode t = head;
        //先找到中间节点
        ListNode temp = findMidNode(head);
        ListNode midNode = temp.next;
        temp.next = null;
        //反转中间节点为头节点的链表
        midNode = reverseNode(midNode);
        //按照特定顺序将原链表的前一半与反转后的链表拼接起来
        ListNode newNode = new ListNode(-1);
        ListNode n = newNode;
        int flag = 1;
        while (t != null && midNode != null) {
            if(flag % 2 == 1) {
                n.next = t;
                t = t.next;
            }else {
                n.next = midNode;
                midNode = midNode.next;
            }
            flag++;
            n = n.next;
        }
        if (t == null && midNode != null) {
            n.next = midNode;
        }else if (t != null && midNode == null) {
            n.next = t;
        }
        head = newNode.next;
    }
    //找到链表的中间节点的上一个节点
    private ListNode findMidNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    //反转节点
    private ListNode reverseNode(ListNode head) {
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
}

class Solution {
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//
//    注意你不能在买入股票前卖出股票
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                sum = prices[i] - prices[j];
                max = max>sum ? max : sum;
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
}