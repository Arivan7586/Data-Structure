package arivan;

public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 8, 6, 0, 4, 9, 3, 5, 7, 1};
//        QuickSort.quickSort(arr);
//        BubbleSort.sort(arr);
//        ChooseSort.sort(arr);
//        InsertSort.sort(arr);
//        InsertSort.binarySort(arr);
//        ShellSort.sort(arr);
        MergeSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

//冒泡排序
class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param arr 被排序的数组
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
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
        }
    }
}

//选择排序
class ChooseSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

//插入排序
class InsertSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] < value) {
                    break;
                } else {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void binarySort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int l = 0;
            int r = i - 1;
            while (r >= l) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > value) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int j = i - 1;
            while (j >= r + 1) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }
}

//希尔排序
class ShellSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n / 2; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (arr[k] > value) {
                        arr[k + i] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k + i] = value;
            }
        }
    }
}

//归并排序
class MergeSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        mergesort(arr, 0, n - 1);
    }

    private static void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);
        partition(arr, l, mid, r);
    }

    private static void partition(int[] arr, int l, int mid, int r) {
        int[] value = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                value[k++] = arr[i++];
            } else {
                value[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            value[k++] = arr[start++];
        }
        for (int m = 0; m < value.length; m++) {
            arr[l + m] = value[m];
        }
    }
}

//快速排序
class QuickSort {

    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        sorting(arr, 0, arr.length - 1);
    }

    private static void sorting(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = partition3(arr, l, r);
        sorting(arr, l, index - 1);
        sorting(arr, index + 1, r);
    }

    // 一路快排
    private static int partition1(int[] arr, int l, int r) {
        int i = l + 1;
        int j = l;
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);
        int value = arr[l];
        while (i <= r) {
            if (arr[i] < value) {
                swap(arr, i, j + 1);
                j++;
            }
            i++;
        }
        swap(arr, l, j);
        return j;
    }

    //二路快排
    private static int partition2(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, randomIndex, l);
        int value = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i] < value) {
                i++;
            }
            while (j >= i && arr[j] > value) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    //三路快排
    private static int partition3(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] > value) {
                swap(arr, i, --k);
            } else if (arr[i] < value) {
                swap(arr, i++, ++j);
            } else {
                i++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}