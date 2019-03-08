package arivan.Test3_8;

/**
 * 线性表（双向链表实现）
 */
public class DoubleLinkedListImpl implements Sequence {
    private ListNode head; //头节点
    private ListNode tail; //尾节点
    private int size; //线性表长度

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

    @Override
    public void add(Object data) { //尾插法

        //产生新节点
        ListNode newNode = new ListNode(tail,data,null);
        if (head == null) {
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        rangCheck(index);
        ListNode temt = findNode(index);
        Object oldData = temt.data;
        ListNode prevNode = temt.prev;
        ListNode nextNode = temt.next;
        if (prevNode == null) {
            //头节点就是temp
            head = nextNode;
        }else {
            prevNode.next = nextNode;
            temt.next = null;
        }
        if (nextNode == null) {
            tail = prevNode;
        }else {
            nextNode.prev = prevNode;
            temt.prev = null;
        }
        size--;
        return oldData;
    }

    @Override
    public Object get(int index) {  //取得指定节点的数据
        rangCheck(index);
        return findNode(index).data;
    }

    @Override
    public boolean contains(Object data) {
        if (data == null) {
            ListNode temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.data == null) {
                    return true;
                }
                temp = temp.next;
            }
        }else {
            ListNode temp = head;
            for (int i = 0; i < size; i++) {
                if (data.equals(temp.data)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangCheck(index);
        ListNode oldNode = findNode(index);
        Object oldData = oldNode.data;
        oldNode.data = newData;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

        while (head != null) {
            ListNode now = head.next;
            head.prev = null;
            head.data = null;
            head.next = null;
            head = now;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    private void rangCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal Index");
        }
    }

    private ListNode findNode(int index) {
        if (index < (size>>1)) {
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = tail.next;
            }
            return temp;
        }else {
            ListNode temp = tail;
            for (int i = size-1; i > index; i--) {
                temp = tail.prev;
            }
            return temp;
        }
    }
}
