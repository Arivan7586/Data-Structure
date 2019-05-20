package arivan.Test5_20;

import java.util.Arrays;

/**
 * 基于数组实现支持动态扩容的栈
 * @param <T>
 */
public class ArrayStack<T> implements MyStack<T>{
    //用于存放数据的数组
    private Object[] Elements;
    //栈的默认最大容量
    private final int DEFAULT_MAXSIZE = 20;

    private int MaxSize;
    //栈当前的元素个数
    private int currentSize;

    public ArrayStack() {
        Elements = new Object[DEFAULT_MAXSIZE];
        this.MaxSize = DEFAULT_MAXSIZE;
    }

    public ArrayStack(int maxSize) {
        Elements = new Object[maxSize];
        this.MaxSize = maxSize;
    }

    @Override
    public void push(T t) {
        if (this.currentSize == this.MaxSize) {
            int oldSize = currentSize;
            int newSize = oldSize << 1;
            if (newSize + 8 > Integer.MAX_VALUE) {
                System.out.println("栈的长度过大");
            } else {
                Elements = Arrays.copyOf(Elements,newSize);
            }
//            System.out.println("栈已满");
        }
        Elements[currentSize++] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            return (T) Elements[--currentSize];
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            return (T) Elements[currentSize - 1];
        }
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }
}
