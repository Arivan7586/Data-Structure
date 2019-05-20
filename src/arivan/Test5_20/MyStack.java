package arivan.Test5_20;

public interface MyStack<T> {
    /**
     * 向栈中添加元素
     * @param t
     */
    void push(T t);

    /**
     * 取出栈顶元素
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return 返回栈顶元素
     */
    T peek();

    /**
     * 返回当前栈的元素个数
     * @return
     */
    int size();

    /**
     * 判断当前栈是否为空
     * @return 为空返回true，否则返回false
     */
    boolean isEmpty();
}
