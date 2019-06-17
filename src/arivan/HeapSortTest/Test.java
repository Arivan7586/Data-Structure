package arivan.HeapSortTest;

import java.net.Socket;
import java.util.*;

public class Test {

    public static void main(String[] args) {

//        int n = 10000000;
//        Random random = new Random();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(Integer.MAX_VALUE);
//        }
////        HeapSort.heapSort1(arr);
//        HeapSort.heapSort2(arr);
////        for (int i : arr) {
////            System.out.print(i+"、");
//        }

        Solution solution = new Solution();
        int[] arr = new int[]{-1,-1};
        List<Integer> list = solution.topKFrequent(arr,1);
        System.out.println(list);
    }
}

//前K个高频元素
class Solution {
    private class Freq implements Comparable<Freq>{
        private int key;
        private int value;

        public Freq(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.value > o.value) {
                return 1;
            }
            if (this.value < o.value) {
                return -1;
            }
            return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(k);
        //将元素添加到map中
        Map<Integer,Freq> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Freq freq = map.get(nums[i]);
                freq.value++;
                map.put(nums[i],freq);
            } else {
                map.put(nums[i],new Freq(nums[i],1));
            }
        }
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(map.get(key));
            } else {
                if (map.get(key).value > priorityQueue.peek().value) {
                    priorityQueue.poll();
                    priorityQueue.add(map.get(key));
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll().key);
        }
        return list;
    }
}