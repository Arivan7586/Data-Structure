package arivan.Test5_23;

public interface MyQueue<E> {

    /**
     * 向队列中加入数据
     * @param e 需要插入的数据
     */
    void enQueue(E e);

    /**
     * 删除队列中的元素
     * @return 返回被删除的元素
     */
    E deQueue();

    /**
     * 查看对头元素
     * @return 返回对头元素
     */
    E peek();

    /**
     * 取得队列的长度
     * @return 返回队列的元素个数
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return 为空返回true，否则返回false
     */
    boolean isEmpty();
}
