package arivan.Test3_15;

public class Test3_15 {
    public static void main(String[] args) {
//        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(Solution.maxSubArray(arr));

        int[] arr = new int[]{3,-3,-1,-1,-4,-2};
        System.out.println(Solution1.maximumProduct(arr));
        Solution1.shellSort(arr);
        printArray(arr);

    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Solution {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                //如果当前子序列大于0，则后面的子序列包含当前序列
                sum += nums[i];
            }else {
                //如果当前子序列小雨或者等于0，后面的子序列不包含当前子序列
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;

//        int n = nums.length;
//        int max = nums[0];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum > max) {
//                    max = sum;
//                }
//            }
//            sum = 0;
//        }
//        return max;
    }
}

class Solution1 {
//    给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//    示例 2:
//    输入: [1,2,3,4]
//    输出: 24
//    注意:
//    给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
//    输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }else if (n == 3) {
            return (nums[0]*nums[1]*nums[2]);
        }else {
            shellSort(nums);
            if (nums[0] <= 0 || nums[n-1] >= 0) {
                return (nums[0]*nums[1]*nums[2]);
            }else if (nums[1] <= 0 || nums[2] <= 0) {
                return (nums[0]*nums[n-1]*nums[n-2]);
            }else {
                if (nums[n-1]*nums[n-2] > nums[1]*nums[2]) {
                    return (nums[0]*nums[n-1]*nums[n-2]);
                }else {
                    return (nums[0]*nums[1]*nums[2]);
                }
            }
        }
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
                    if (value > arr[k]) {
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