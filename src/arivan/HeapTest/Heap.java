package arivan.HeapTest;


import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {
    //用于存放数据的数组
    private E[] Elements;
    //用于存放
    private int size;
    //比较器
    private Comparator<E> comparator;

    private static final Integer DEFAULT_SIZE = 10;

    public Heap() {
        this(DEFAULT_SIZE,null);
    }

    public Heap(int length) {
        this(length,null);
    }

    public Heap(int length,Comparator<E> comparator) {
        this.Elements = (E[]) new Object[length];
        this.comparator = comparator;
    }

    /**
     * 将任意数组转换为堆
     * @param arr 需要转换的数组
     */
    public Heap(E[] arr) {
        Elements = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Elements[i] = arr[i];
        }
        size = Elements.length;
        //从最后一个非叶子节点开始，做元素下沉操作
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 将堆顶元素替换为新元素
     * @param newvalue 需要替换的元素
     * @return 返回替换前的堆顶元素
     */
    public E replace(E newvalue) {
        E value = getMax();
        Elements[0] = newvalue;
        siftDown(0);
        return value;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            if (Elements[i] != null)
            str.append(Elements[i] +"、");
        }
        return String.valueOf(str);
    }

    /**
     * 删除最大元素
     * @return 返回最大的元素
     */
    public E getMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("当前堆为空");
        }
        //大顶堆
        return Elements[0];
    }

    /**
     * 取出最大元素
     * @return
     */
    public E extractMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("当前堆为空");
        }
        E res = getMax();
        //删除最大值
        Elements[0] = Elements[size - 1];
        Elements[--size] = null;
        //元素下沉
        siftDown(0);
        return res;
    }

    /**
     * 将二叉树当前节点下沉到正确位置
     * @param index 当前节点
     */
    private void siftDown(int index) {
        while (leftChildIndex(index) < size) {
            //当前节点左孩子索引下标
            int i = leftChildIndex(index);
            //判断节点左右孩子的大小
            if (i + 1 < size) {
                //此时有右孩子
                if (compare(Elements[i],Elements[i+1]) < 0) {
                    i++;
                }
            }
            if (compare(Elements[index],Elements[i]) > 0) {
                break;
            }
            swap(index,i);
            index = i;
        }
    }

    /**
     * 添加元素（默认在数组的末尾添加）
     * @param e 需要添加的元素
     */
    public void addData(E e) {
        if (size == Elements.length) {
            group();
        }
        //向数组添加元素
        Elements[size++] = e;
        //元素上浮
        siftUp(size - 1);
    }

    /**
     * 元素上浮(调整当前节点在堆中的位置)
     */
    private void siftUp(int index) {
        while (index > 0 && compare(Elements[index],Elements[parentIndex(index)]) > 0) {
            //需要交换当前节点与父节点的值
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    /**
     * 交换元素
     * @param a 元素1的下标
     * @param b 元素2的下标
     */
    private void swap(int a,int b) {
        E temp = Elements[a];
        Elements[a] = Elements[b];
        Elements[b] = temp;
    }

    /**
     * 数组扩容
     */
    private void group() {
        int oldLength = Elements.length;
        int newLength = oldLength + (oldLength < 64 ? oldLength :
                oldLength >> 1);
        if (newLength >= Integer.MAX_VALUE - 8) {
            throw new IndexOutOfBoundsException("数组太大");
        }
        Elements = Arrays.copyOf(Elements,newLength);
    }

    /**
     * 判断当前堆是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 取得当前堆的元素个数
    * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 比较两个元素的大小
     * @param o1 元素1
     * @param o2 元素2
     * @return 返回比较的结果
     */
    private int compare(E o1, E o2) {
        if (comparator == null) {
            return ((Comparable<E>)o1).compareTo(o2);
        }
        return comparator.compare(o1,o2);
    }

    /**
     * 取得当前节点的左孩子节点下标
     * @param index 当前节点下标
     * @return
     */
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * 取得当前节点的右孩子节点的下标
     * @param index 当前节点下标
     * @return
     */
    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    /**
     * 取得当前节点的父节点下标
     * @param index 当前节点下标
     * @return
     */
    private int parentIndex(int index) {
        if (index == 0) {
            throw new IndexOutOfBoundsException("当前节点没有父节点");
        }
        return (index - 1) / 2;
    }
}

