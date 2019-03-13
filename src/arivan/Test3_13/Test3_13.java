package arivan.Test3_13;

public class Test3_13 {
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
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        //p2.next = p3;
        p3.next = p4;
        p4.next = p5;

//        printNode(p1);
//        System.out.println();
//        ListNode node = reverseBetween(p1,1,2);
        //ListNode node = oddEvenList(p1);
//        printNode(node);

        int[] arr = new int[]{5,3,8,4,1,0,9,6,7,2};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

//    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点
//    指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，
//    nodes 为节点总数。
//    示例 2:
//    输入: 2->1->3->5->6->4->7->NULL
//    输出: 2->3->6->7->1->5->4->NULL
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = head;

        ListNode node = head.next;
        ListNode nextNode = head.next;
        while (node != null && node.next != null) {
            head.next = head.next.next;
            head = head.next;
            node.next = node.next.next;
            node = node.next;
        }
        head.next = nextNode;
        return dummyHead;
    }

    //反转链表
    public static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = head;
        ListNode s = f.next;
        while (s != null && f.next != null) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        return dummyHead.next;
    }


    //快速排序
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        quickSortIntertion(arr,0,n-1);
    }
    public static void quickSortIntertion(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int value = partition(arr,l,r);
        quickSortIntertion(arr,l,value-1);
        quickSortIntertion(arr,value+1,r);
    }

    /**
     * 分区点选区方法
     * @param arr
     * @param l
     * @param r
     * @return 返回已经到达最终位置的分区点下标
     */
    public static int partition(int[] arr, int l, int r) {
        int value = arr[l];
        int j = l;
        int i = l + 1;
        while (i <= r) {
            if (arr[i] < value) {
                swap(arr,i,j+1);
                j++;
            }
            i++;
        }
        swap(arr,l,j);
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

