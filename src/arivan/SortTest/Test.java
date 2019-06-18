package arivan.SortTest;

import java.util.Random;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        int n = 10000;
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
//        printArray(arr);

        System.out.println();
        //测试排序算法是否正确
        testSort();


//        Sort.bubbleSort(makeArray(100000));
//        Sort.chooseSort(makeArray(100000));
//        Sort.insertSort(makeArray(100000));
//        Sort.binaryInsertSort(makeArray(100000));
//        Sort.shellSort(makeArray(10000000));
//        Sort.mergeSort(makeArray(10000000));
//        Sort.heapSort(makeArray(10000000));
//        Sort.quickSort(makeArray(10000000));
//        Sort.quickSort1(makeArray(10000000));

//        printArray(arr);
    }
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "、");
        }
    }

    public static void testSort() {
        Random random = new Random();
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

//        Sort.chooseSort(arr);
//        Sort.bubbleSort(arr);
//        Sort.insertSort(arr);
//        Sort.binaryInsertSort(arr);
//        Sort.shellSort(arr);
//        Sort.mergeSort(arr);
//        Sort.heapSort(arr);
//        Sort.quickSort(arr);

        QuickSort.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                System.out.println("排序出错");
            }
        }
        System.out.println("测试通过");
//        printArray(arr);
    }

    private static int[] makeArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }
}

class QuickSort {
    public static void sort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int l = 0;
        int r = n - 1;
        Stack<Integer> stack = new Stack<>();
        int flag = findValue(arr,l,r);
        if (flag > l + 1) {
            stack.push(l);
            stack.push(flag-1);
        }
        if (flag < r - 1) {
            stack.push(flag + 1);
            stack.push(r);
        }
        while (!stack.isEmpty()) {
            r = stack.pop();
            l = stack.pop();
            flag = findValue(arr,l,r);
            if (flag > l + 1) {
                stack.push(l);
                stack.push(flag-1);
            }
            if (flag < r - 1) {
                stack.push(flag + 1);
                stack.push(r);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("非递归快速排序用时："+ (end - start) + "毫秒");
    }
    private static int findValue(int[] arr, int l, int r) {
        int randomValue = (int) (Math.random() * (r - l + 1) + l);
        int value = arr[randomValue];
        swap(arr,l,randomValue);
        int i = l + 1;
        int j = r + 1;
        int k = l;
        while (i < j) {
            if (arr[i] < value) {
                swap(arr,i++,++k);
            } else if (arr[i] > value) {
                swap(arr,i,--j);
            } else {
                i++;
            }
        }
        swap(arr,l,k);
        return k;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}