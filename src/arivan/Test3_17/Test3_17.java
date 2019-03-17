package arivan.Test3_17;

public class Test3_17 {
    public static void main(String[] args) {

        int[] arr = new int[]{6,2,7,0,9,4,1,5,3,8};
        printArray(arr);
//        Sort.bubbleSort(arr);
//        Sort.chooseSort(arr);
//        Sort.insertSort(arr);
//        Sort.binaryInsertSort(arr);
//        Sort.shellSort(arr);
//        Sort.mergeSort(arr);
        Sort.quickSort(arr);
        printArray(arr);

    }
    public static void printArray(int[] arr) { //输出数组
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Sort {
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean f = false; //优化点
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    f = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!f) {
                break;
            }
        }
    }

    //选择排序
    public static void chooseSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (val < arr[j]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = val;
        }
    }

    //折半插入排序
    public static void binaryInsertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int l = 0;
            int r = i - 1;
            while (r >= l) {
                int mid = l + (r - l)/2;
                if (val >= arr[mid]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            int j = i - 1;
            while (j >= r+1) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }

    //shell排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n/2; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                int val = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (val < arr[k]) {
                        arr[k+i] = arr[k];
                        k -= i;
                    }else {
                        break;
                    }
                }
                arr[k+i] = val;
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        mergeInternal(arr, 0, n-1);
    }
    public static void mergeInternal(int[] arr, int l, int r) {
        if (r - l <= 15) {
            //调用直接插入排序
            insertSort(arr);
            return;
        }
        int mid = l + (r - l)/2;
        mergeInternal(arr,l,mid);
        mergeInternal(arr,mid+1,r);
        if (arr[mid] >= arr[mid+1]) {
            merge(arr,l,mid,r);
        }
    }
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] array = new int[r-l+1];
        int i = l;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                array[k++] = arr[i++];
            }else {
                array[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            array[k++] = arr[start++];
        }
        for (int m = 0; m < r - l + 1; m++) {
            arr[l+m] = array[m];
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    public static void quickSortInternal(int[] arr, int l, int r) {
        if (r - l <= 15) {
            //调用直接插入排序
            insertSort(arr);
            return;
        }
        int value = findValue2(arr,l,r);
        quickSortInternal(arr,l,value-1);
        quickSortInternal(arr,value+1,r);
    }
    public static int findValue(int[] arr, int l, int r) {
        int value = arr[l];
        int i = l + 1;
        int j = l;
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
    //快速排序优化1：二路快排
    public static int findValue1(int[] arr, int l, int r) {
        int randomIndex = (int)(Math.random()*(r-l+1)) + l;
        int value = arr[randomIndex];
        swap(arr,l,randomIndex);
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < value) {
                i++;
            }
            while (j >= l+1 && arr[j] > value) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,j,l);
        return j;
    }
    //快速排序优化2：三路快排
    public static int findValue2(int[] arr, int l, int r) {
        int randomIndex = (int)(Math.random()*(r-l+1) + l);
        int value = arr[randomIndex];
        swap(arr,l,randomIndex);
        int e = l;
        int i = l + 1;
        int j = r + 1;
        while (i < j) {
            if (arr[i] < value) {
                swap(arr,i,e+1);
                e++;
                i++;
            }else if (arr[i] > value) {
                swap(arr,i,j-1);
                j--;
            }else {
                i++;
            }
        }
        swap(arr,l,e);
        return e;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}