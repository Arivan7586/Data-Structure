package arivan.Test5_20;

/**
 * 基于链表实现的栈
 * @param <T>
 */
public class LinkedStack<T> implements MyStack<T> {

    private class ListNode {
        T data;
        ListNode next;

        public ListNode(T data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    //栈顶元素
    private ListNode top;
    //栈中元素的个数
    private static int currentSize;


    @Override
    public void push(T t) {
        ListNode newNode = new ListNode(t,null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        currentSize++;
    }

    @Override
    public T pop() {
        if (currentSize == 0) {
            System.out.println("当前栈为空");
            return null;
        }
        T value = top.data;
        top = top.next;
        currentSize--;
        return value;
    }

    @Override
    public T peek() {
        if (currentSize == 0) {
            System.out.println("当前栈为空");
            return null;
        }
        return top.data;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
