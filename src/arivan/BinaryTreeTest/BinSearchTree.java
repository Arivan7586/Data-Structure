package arivan.BinaryTreeTest;

/**
 * 搜索二叉树
 * @param <E>
 */
public class BinSearchTree<E extends Comparable<E>> implements BinaryTree<E> {
    private class Node {
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }
    }

    //当前链表的节点数
    private int size;

    //根节点
    private Node root;

    //记录最大的元素
    private E max;

    //记录最小的元素
    private E min;

    @Override
    public void add(E e) {
        if (isEmpty()) {
            Node newNode = new Node(e);
            max = e;
            min = e;
            this.root = newNode;
            size++;
        } else {
            if (addData(this.root,e)) {
                size++;
                this.max = e.compareTo(this.max) > 0 ? e : this.max;
                this.min = e.compareTo(this.max) < 0 ? e : this.min;
            }
        }
    }
    private boolean addData(Node root, E e) {
        Node newNode = new Node(e);
        if (root == null) {
            root = newNode;
            return true;
        } else if (e.equals(root.data)) {
            return false;
        } else if (e.compareTo(root.data) < 0 && root.left == null) {
            root.left = newNode;
            return true;
        } else if (e.compareTo(root.data) > 0 && root.right == null) {
            root.right = newNode;
            return true;
        }
        else {
            if (e.compareTo(root.data) < 0) {
                return addData(root.left,e);
            } else {
                return addData(root.right,e);
            }
        }
    }

    @Override
    public boolean remove(E e) {

        return false;
    }

    @Override
    public E getMax() {
        return this.max;
    }

    @Override
    public E getMin() {
        return this.min;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
