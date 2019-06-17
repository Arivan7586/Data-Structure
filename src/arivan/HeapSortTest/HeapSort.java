package arivan.HeapSortTest;

import arivan.HeapTest.Heap;

public class HeapSort {

    public static void heapSort1(Integer[] arr) {
        long start = System.currentTimeMillis();
        Heap<Integer> heap = new Heap<>(arr);
        int[] nums = new int[arr.length];
        for (int i = heap.getSize() - 1; i >= 0; i--) {
            nums[i] = heap.extractMax();
        }
        long end = System.currentTimeMillis();
        System.out.println("堆排序共耗时：" + (end - start) + "毫秒");
    }

    /**
     * 原地堆排序
     *
     * @param arr 待排序数组
     */
    public static void heapSort2(int[] arr) {
        long start = System.currentTimeMillis();
        //将数组变为堆
        int length = arr.length;
        for (int i = length - 1 - 1; i >= 0; i--) {
            siftDown(arr, length, i);
        }
        //将数组中最大值换到数组末端
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            siftDown(arr, i, 0);
        }
        long end = System.currentTimeMillis();
        System.out.println("原地堆排序共耗时：" + (end - start) + "毫秒");
    }

    private static void siftDown(int[] arr, int n, int index) {
        while (index * 2 + 1 < n) {
            int j = 2 * index + 1;
            if (j + 1 < n) {
                if (arr[j] < arr[j + 1]) {
                    j++;
                }
            }
            if (arr[index] > arr[j]) {
                break;
            }
            swap(arr, index, j);
            index = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


