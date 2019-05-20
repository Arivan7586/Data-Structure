package arivan.Test5_20;

import java.util.*;

public class Test {

    public static void main(String[] args) {

//        MyStack<Integer> stack = new LinkedStack<>();
//        MyStack<Integer> stack = new ArrayStack<>(2);
//        System.out.println(stack.isEmpty());
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());

        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}

/**
 * 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 */
class MinStack {
    private Stack<Long> stack;
    private Long min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = (long) x;
            stack.push(0L);
        } else {
            stack.push((long) x - min);
            if (x < min)
                min = (long) x;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long v = stack.pop();
        if (v < 0)
            min = min - v;
    }

    public int top() {
        Long top = stack.peek();
        if (top < 0)
            return Math.toIntExact(min);
        return Math.toIntExact(top + min);
    }

    public int getMin() {
        return Math.toIntExact(min);

    }
}

class MinStack1 {
    private static Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int value = stack.peek();
            stack.push(x);
            value = x < value ? x : value;
            stack.push(value);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }
}