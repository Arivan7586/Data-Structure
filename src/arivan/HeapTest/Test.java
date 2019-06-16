package arivan.HeapTest;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        //测试添加元素
//        int[] arr = new int[]{62,41,30,28,16,22,13,19,17,15};
//        Heap<Integer> heap = new Heap<>();
//        for (int i = 0; i < arr.length; i++) {
//            heap.addData(arr[i]);
//        }
//        System.out.println(heap);
//        heap.addData(52);
//        System.out.println(heap);
//
//        System.out.println(heap.extractMax());
//        System.out.println(heap.getMax());
//        System.out.println(heap);

        //测试删除堆的最大值
//        int n = 50;
//        Heap<Integer> heap = new Heap<>(n);
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            heap.addData(random.nextInt(1000));
//        }
//        int[] arr = new int[n];
////        int i = 0;
////        while (!heap.isEmpty()) {
////            arr[i++] = heap.extractMax();
////        }
////        for (int j = 1; j < n; j++) {
////            if (arr[j-1] < arr[j]) {
////                throw new IllegalArgumentException("Error");
////            }
////        }
//        for (int j = heap.getSize() - 1; j >= 0; j--) {
//            arr[j] = heap.extractMax();
//        }
//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j] +"、");
//        }
//        System.out.println("Test Completed");

        //测试替换堆顶元素
//        Heap<Integer> heap = new Heap<>();
//        int[] arr = new int[]{62,41,30,28,16,22,13,19,17,15};
//        for (int i = 0; i < arr.length; i++) {
//            heap.addData(arr[i]);
//        }
//        System.out.println(heap.replace(25));
//        System.out.println(heap.getMax());
//

        //测试将任意数组转换为堆的操作

        Integer[] nums = new Integer[]{15,17,19,13,22,16,28,30,41,62};
        Heap<Integer> heap = new Heap<>(nums);
        System.out.println(heap);
    }
}
