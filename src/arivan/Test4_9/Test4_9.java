package arivan.Test4_9;

import java.util.*;

public class Test4_9 {
    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//        list.add("D");
//        list.add("C");
//        list.add("G");
//        list.add("a");
//        list.add("j");
//        list.add("b");
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);

        Solution solution = new Solution();
        System.out.println(solution.GetLeastNumbers_Solution(new int[]{
                4,5,1,6,2,7,3,8},10));
        int[] arr = new int[]{1,1,2,2,3,3,4,5,5,6,6,8,9,9};
        int[] arr1 = new int[]{1,1,2};
        int[] a = new int[1];
        int[] b = new int[1];

        Solution1 solution1 = new Solution1();
        solution1.FindNumsAppearOnce(arr1,a,b);

        Solution2.ListNode p1 = new Solution2.ListNode(1);
        Solution2.ListNode p2 = new Solution2.ListNode(2);
        Solution2.ListNode p3 = new Solution2.ListNode(3);
        Solution2.ListNode p4 = new Solution2.ListNode(4);
        Solution2.ListNode p5 = new Solution2.ListNode(5);
        Solution2.ListNode p6 = new Solution2.ListNode(6);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        //p6.next = p3;

        System.out.println("--------------------");
        Solution2 solution2 = new Solution2();
        if (solution2.EntryNodeOfLoop(p1) == null) {
            System.out.println("null");
        }else {
            System.out.println(solution2.EntryNodeOfLoop(p1).val);
        }
    }
}

class Solution {

    /**
     * 最小k个数字
     * @param input 给定数组
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        Arrays.sort(input);
        if (input.length < k) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            if (i >= input.length) {
                break;
            }
            list.add(input[i]);
        }
        return list;
    }
}

class Solution1 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array 给定的整形数组
     * @param num1 存放只出现一次元素的数组
     * @param num2 存放只出现一次元素的数组
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 1) {
            //return;
        }else if (array.length == 1) {
            num1[0] = array[0];
            //return;
        }else if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            //return;
        }else {
            Arrays.sort(array);
            if (array[0] != array[1]) {
                num1[0] = array[0];
            }
            int flag = 0;
            int i = 1;
            for (; i < array.length-1; i++) {
                if (array[i] != array[i-1] && array[i] != array[i+1]) {
                    if (flag == 0) {
                        num1[0] = array[i];
                        flag++;
                    }else {
                        num2[0] = array[i];
                        break;
                    }
                }
            }
            if (array[i] != array[i-1]) {
                num2[0] = array[i];
            }
        }

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}

class Solution2 {
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

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        List<ListNode> listNodes = new LinkedList<>();
        while (pHead != null) {
            if (listNodes.contains(pHead)) {
                return pHead;
            }
            listNodes.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 判断一个链表有环
     * @param head 给定链表的头节点
     * @return 有环返回true，否则返回false
     */
    public boolean circleList(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = head.next;
        ListNode s = head;
        while (s != f) {
            if (f == null || f.next == null) {
                return false;
            }
            f = f.next.next;
            s = s.next;
        }
        return true;
    }
}