package arivan.Test3_11;

public class Test3_11 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(arr1,3,arr2,3);
        printArray(arr1);
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

//    给定两个有序整数数组 nums1 和 nums2，
//        将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }
        System.arraycopy(nums2,0,nums1,m,n);
        shellSort(nums1);

    }
    public static void shellSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n/2; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (value < arr[k]) {
                        arr[k+i] = arr[k];
                        k -= i;
                    }else {
                        break;
                    }
                }
                arr[k+i] = value;
            }
        }
    }
}

class Solution1 {
    //给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
    public int missingNumber(int[] nums) {
        //先给数组排序，本次采用折半插入排序法
        int n = nums.length;
        if (n < 1) {
            return 0;
        }else if (n == 1 && nums[0] == 1) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int right = i-1;
            int left = 0;
            while (right >= left) {
                int mid = left + (right-left)/2;
                if (value < nums[mid]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            int j = i - 1;
            while (j >= right+1) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = value;
        }

        for (int i = 0; i < n-1; i++) {
            if (nums[0] != 0) {
                return 0;
            }
            if (nums[i+1] != nums[i] && nums[i+1] - nums[i] != 1) {
                return nums[i]+1;
            }
        }
        return nums[n-1]+1;
    }
}

class Solution2 {
//    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    private class ListNode {
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            int t = temp.val;
            temp.val = temp.next.val;
            temp.next.val = t;
            temp = temp.next.next;
        }
        return head;
    }
}

class Solution3 {
//    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//    说明:
//    返回的下标值（index1 和 index2）不是从零开始的。
//    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] arr = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (numbers[i]+numbers[j] == target) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                    return arr;
                }
            }
        }
        return null;
    }
}