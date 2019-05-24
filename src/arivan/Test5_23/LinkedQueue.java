package arivan.Test5_23;

import arivan.Test5_20.MyStack;


/**
 * 基于链表实现的队列
 * @param <E>
 */
public class LinkedQueue<E> implements MyQueue<E> {

    private ListNode head;

    private ListNode tail;

    private static int size;

    private class ListNode {
        Object data;
        ListNode next;

        public ListNode(Object e, ListNode next) {
            this.data = e;
            this.next = next;
        }
    }

    @Override
    public void enQueue(E e) {
        ListNode newNode = new ListNode(e,null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            return null;
        } else {
            E data = (E) head.data;
            head.data = null;
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            size--;
            return data;
        }
    }

    @Override
    public E peek() {
        return (E) head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
