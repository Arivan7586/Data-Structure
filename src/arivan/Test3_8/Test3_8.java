package arivan.Test3_8;

public class Test3_8 {
    private class ListNode {
        ListNode prev;  //前驱节点
        Object data;
        ListNode next; //下一个节点

        public ListNode(Object data) {
            this.data = data;
        }

        public ListNode(ListNode prev, Object data, ListNode next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Sequence sequence = new DoubleLinkedListImpl();
        //增加节点
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        sequence.add(5);

        System.out.println("线性表长度为："+sequence.size());
        Object[] arr = sequence.toArray();
        for (Object o : arr) {
            System.out.print(o+" ");
        }
        System.out.println();

        //测试删除节点
        System.out.println("删除的数据为："+sequence.remove(0));
        System.out.println("线性表长度为："+sequence.size());
        Object[] arr2 = sequence.toArray();
        for (Object o : arr2) {
            System.out.print(o+" ");
        }
        System.out.println();

        //测试contains方法
//        System.out.println(sequence.contains(null));

        //测试修改节点数据的方法
//        sequence.set(3,999);
//        Object[] arr1 = sequence.toArray();
//        for (Object o : arr1) {
//            System.out.print(o+" ");
//        }
//        System.out.println();

        //测试取得指定节点数据的方法
//        System.out.println(sequence.get(0));

        //测试转为数组的方法
//        System.out.println("-------------");
//        sequence.clear();
//        Object[] arr1 = sequence.toArray();
//        for (Object o : arr1) {
//            System.out.print(o+" ");
//        }
    }
}
