package arivan.SortTest;


import java.util.Map;
import java.util.Stack;

public class Sort {
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序用时：" + (end - start) + "毫秒");
    }

    //选择排序
    public static void chooseSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序用时：" + (end - start) + "毫秒");
    }

    //插入排序
    public static void insertSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        long end = System.currentTimeMillis();
        System.out.println("插入排序用时：" + (end - start) + "毫秒");
    }

    //折半插入排序
    public static void binaryInsertSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int r = i - 1;
            int l = 0;
            while (r >= l) {
                int mid = l + (r - l) / 2;
                if (value >= arr[mid]) {
                    l = mid + 1;
                } else if (value < arr[mid]) {
                    r = mid - 1;
                }
            }
            int j = i - 1;
            while (j >= r + 1) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
        long end = System.currentTimeMillis();
        System.out.println("折半插入排序用时：" + (end - start) + "毫秒");
    }

    //希尔排序
    public static void shellSort(int[] arr) {
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
                        arr[k+1] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k + i] = value;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔排序用时：" + (end - start) + "毫秒");
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        partition(arr,0,n-1);
        long end = System.currentTimeMillis();
        System.out.println("归并排序用时：" + (end - start) + "毫秒");
    }
    private static void partition(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        partition(arr,l,mid);
        partition(arr,mid+1,r);
        if (arr[mid] > arr[mid+1]) {
            merge(arr,l,mid,r);
        }
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] nums = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                nums[k++] = arr[i++];
            } else {
                nums[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            nums[k++] = arr[start++];
        }
        for (int m = 0; m < nums.length; m++) {
            arr[l+m] = nums[m];
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        sortInternal(arr,0,n-1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序用时：" + (end - start) + "毫秒");
    }
    private static void sortInternal(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int value = findValue3(arr,l,r);
        sortInternal(arr,l,value-1);
        sortInternal(arr,value+1,r);
    }
    private static int findValue1(int[] arr, int l, int r) {
        int randomValue = (int) (Math.random() * (r - l + 1) + l);
        int i = l + 1;
        int j = l;
        int value = arr[randomValue];
        swap(arr,l,randomValue);
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
    private static int findValue2(int[] arr, int l, int r) {
        int randomValue = (int) (Math.random() * (r - l + 1) + l);
        int value = arr[randomValue];
        swap(arr,randomValue,l);
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i] < value) {
                i++;
            }
            while (j >= i && arr[j] > value) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i++,j--);
        }
        swap(arr,l,j);
        return j;
    }
    private static int findValue3(int[] arr, int l, int r) {
        int randomValue = (int) (Math.random() * (r - l + 1) + l);
        int value = arr[randomValue];
        swap(arr,l,randomValue);
        int i = l + 1;
        int j = r + 1;
        int k = l;
        while (i < j) {
            if (arr[i] < value) {
                swap(arr,i,++k);
                i++;
            } else if (arr[i] > value) {
                swap(arr,i,--j);
            } else {
                i++;
            }
        }
        swap(arr,l,k);
        return k;
    }

    //快速排序（非递归）
    public static void quickSort1(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        int r = n - 1;
        int value = findValue3(arr,l,r);
        if (value > l + 1) {
            stack.push(l);
            stack.push(value - 1);
        }
        if (value < r - 1) {
            stack.push(value + 1);
            stack.push(r);
        }
        while (!stack.isEmpty()) {
            r = stack.pop();
            l = stack.pop();
            value = findValue3(arr, l, r);
            if (value > l + 1) {
                stack.push(l);
                stack.push(value - 1);
            }
            if (value < r - 1) {
                stack.push(value + 1);
                stack.push(r);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("非递归快速排序用时：" + (end - start) + "毫秒");
    }

    //堆排序
    public static void heapSort(int[] arr) {
        long start = System.currentTimeMillis();
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        // 将给定数组变为大顶堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr,n,i);
        }
        //将大顶堆的最大元素取出，放在最终位置
        for (int i = n - 1; i >= 0; i--) {
            swap(arr,i,0);
            siftDown(arr,i,0);
        }
        long end = System.currentTimeMillis();
        System.out.println("堆排序用时：" + (end - start) + "毫秒");
    }

    /**
     * 将给定下标的元素移动到正确的位置（元素下沉）
     * @param arr 给定数组
     * @param n 给定数组的长度
     * @param index 待移动元素的下标
     */
    private static void siftDown(int[] arr, int n, int index) {
        while (index * 2 + 1 < n) { //判断当前节点是否为最后一个非叶子节点
            int i = index * 2 + 1;
            if (i + 1 < n) { //判断当前节点是否存在右子树
                if (arr[i] < arr[i+1]) {
                    i++;
                }
            }
            //判断当前节点的值是否小于较大节点的值
            if (arr[index] > arr[i]) {
                return;
            }
            swap(arr,index,i);
            index = i;
        }
    }

    /**
     * 交换给定数组中指定下标的两个元素
     * @param arr 给定数组
     * @param i 待交换元素1
     * @param j 待交换元素2
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
