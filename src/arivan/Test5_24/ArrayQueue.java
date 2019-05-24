package arivan.Test5_23;

/**
 * 基于数组实现的队列
 * @param <T> 队列中的元素
 */
public class ArrayQueue<T> implements MyQueue<T> {

    private Object[] data;

    private int size;

    private int head;

    private int tail;

    public ArrayQueue(int n) {
        this.data = new Object[n];
    }

    @Override
    public void enQueue(T t) {
        if (head == (tail+1) % data.length) {
            System.err.println("当前队列已满");
        } else {
            data[tail] = t;
            tail = (tail+1) % data.length;
            size++;
        }
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            return null;
        } else {
            T value = (T) data[head];
            data[head] = null;
            head = (head+1) % data.length;
            size--;
            return value;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T)data[this.head];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
