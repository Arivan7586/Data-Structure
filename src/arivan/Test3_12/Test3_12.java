package arivan.Test3_12;

public class Test3_12 {
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
    public static void main(String[] args) {
//        int[] arr1 = new int[]{1,2,2,3};
//        int[] arr2 = new int[]{6,5,4,4};
//        int[] arr3 = new int[]{1,3,2,6};
//        Solution solution = new Solution();
//        System.out.println(solution.isMonotonic(arr1));
//        System.out.println(solution.isMonotonic(arr2));
//        System.out.println(solution.isMonotonic(arr3));

//        int[][] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
//        Solution1 solution1 = new Solution1();
//        int[][] arr1 = solution1.imageSmoother(arr);
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1[i].length; j++) {
//                System.out.print(arr1[i][j]+" ");
//            }
//            System.out.println();
//        }

        Solution2.ListNode p1 = new Solution2.ListNode(1);
        Solution2.ListNode p2 = new Solution2.ListNode(2);
        Solution2.ListNode p3 = new Solution2.ListNode(3);
        Solution2.ListNode p4 = new Solution2.ListNode(3);
        Solution2.ListNode p5 = new Solution2.ListNode(4);
        Solution2.ListNode p6 = new Solution2.ListNode(4);
        Solution2.ListNode p7 = new Solution2.ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = null;
        Solution2 solution2 = new Solution2();
        solution2.deleteSameNode(p1,1);
        //solution2.deleteDuplication(p1);
        solution2.printNode(p1);

    }

}

class Solution {
//    如果数组是单调递增或单调递减的，那么它是单调的。
//
//    如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
//    如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
//
//    当给定的数组 A 是单调数组时返回 true，否则返回 false。
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < n-1; i++) {
            if (A[i] <= A[i+1]) {
                sum++;
            }else {
                sum--;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if (A[i] >= A[i+1]) {
                sum1++;
            }else {
                sum1--;
            }
        }
        if (sum == n-1 || sum1 == n-1) {
            return true;
        }
        return false;
    }
}

class Solution1 {
//    包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度
//            (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，
//    则尽可能多的利用它们。
    public int[][] imageSmoother(int[][] M) {
        int[][] arr = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                arr[i][j] = addAround(M,i,j);
            }
        }
        return arr;
    }
    public int addAround(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;
        int count = 0;
        int sum = 0;
        for (int a = i-1; a <= i+1; a++) {
            for (int b = j-1; b <= j+1; b++) {
                if (a >= 0 && a < m && b >= 0 && b < n) {
                    sum += arr[a][b];
                    count++;
                }
            }
        }
        return sum/count;
    }
}

class Solution2 {
//    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
//    返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode temp = pHead;
        ListNode preHead = dummyHead;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                int value = temp.val;
                while (temp != null && temp.val == value) {
                    temp = temp.next;
                }
                preHead.next = temp;
            }else {
                preHead = temp;
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode deleteSameNode(ListNode head, int val) { //删除链表指定元素
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (head != null) {
            if (head.val == val) {
                ListNode p = head;
                while(p.next.next != null) {
                    p.val = p.next.val;
                    p = p.next;
                }
                p.val = p.next.val;
                p.next = null;
            }else {
                head = head.next;
            }
        }
//        if (dummyHead.next == null) {
//            return null;
//        }
        return dummyHead.next;
    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}