package arivan.Test5_23;

public class TestMyQueue {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new ArrayQueue<>(5);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.getSize());
        myQueue.enQueue(5);
        System.out.println(myQueue.getSize());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.getSize());
    }
}
