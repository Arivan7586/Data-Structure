package arivan.Test3_10;

public class Test3_10 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,4,2,8,3,1,9,0,7};
        printArray(arr);
        System.out.println();
//        Sort.bubbleSort(arr);
//        Sort.chooseSort(arr);
//        Sort.insertSort(arr);
//        Sort.binarySort(arr);
        Sort.shellSort(arr);
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

class Sort { //排序算法
    public static void bubbleSort(int[] arr) { //冒泡排序
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
            long end = System.currentTimeMillis();
            System.out.println("冒泡排序用时：" + (end - start) + "毫秒");
        }
    }

    public static void chooseSort(int[] arr) { //选择排序
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序用时：" + (end - start) + "毫秒");
    }

    public static void insertSort(int[] arr) { //插入排序
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                j--;
            }
            arr[j + 1] = value;
        }
        long end = System.currentTimeMillis();
        System.out.println("插入排序用时：" + (end - start) + "毫秒");
    }

    public static void binarySort(int[] arr) { //折半插入排序
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int low = 0;
            int high = i - 1;
            while (high >= low) {
                int mid = low + (high - low) / 2;
                if (value >= arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int j = i - 1;
            while (j >= high + 1) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
            long end = System.currentTimeMillis();
            System.out.println("折半插入排序用时：" + (end - start) + "毫秒");
        }
    }

    public static void shellSort(int[] arr) { //希尔排序
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n / 2; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (value < arr[k]) {
                        arr[k + i] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k + i] = value;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("shell排序用时：" + (end - start) + "毫秒");
    }
}
