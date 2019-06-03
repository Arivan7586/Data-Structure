package arivan.BinaryTreeTest;

import java.util.LinkedList;
import java.util.Queue;

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

    @Override
    public void add(E e) {
        if (isEmpty()) {
            Node newNode = new Node(e);
            this.root = newNode;
            size++;
        } else {
            if (addData(this.root,e)) {
                size++;
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
        if (containsNode(e)) {
            this.root = removeNode(this.root,e);
            return true;
        }
        return false;
    }
    private Node removeNode(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.data) < 0) {
            node.left = removeNode(node.left,e);
        } else if (e.compareTo(node.data) > 0) {
            node.right = removeNode(node.right,e);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else if (node.right != null && node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else  {
                node.data = getMinNode(node.right).data;
                node.right = removeMinNode(node.right);
                return node;
            }
        }
        return node;
    }

    @Override
    public E getMax() {
//        return this.max;
        return getMaxNode(this.root).data;
    }

    /**
     * 取得以node为根节点的二分搜索数中最小子节点
     * @param node 根节点
     * @return 返回最小节点
     */
    private Node getMaxNode(Node node) {
        return node.right == null ? node : getMaxNode(node.right);
    }

    @Override
    public E getMin() {
//        return this.min;
        return getMinNode(this.root).data;
    }

    /**
     * 取得以node为根节点的二分搜索数中最小子节点
     * @param node 根节点
     * @return 返回最小节点
     */
    private Node getMinNode(Node node) {
        return node.left == null ? node : getMinNode(node.left);
    }

    @Override
    public void preOrder() {
        if (isEmpty()) {
            System.out.println("当前二叉树为空");
        } else {
            System.out.print("二叉树前序遍历：");
            preRun(this.root);
        }
    }
    private void preRun(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preRun(node.left);
        preRun(node.right);
    }

    @Override
    public void inOrder() {
        if (isEmpty()) {
            System.out.println("当前二叉树为空");
        } else {
            System.out.print("二叉树中序遍历：");
            inRun(this.root);
        }
    }
    private void inRun(Node node) {
        if (node == null) {
            return;
        }
        inRun(node.left);
        System.out.print(node.data + " ");
        inRun(node.right);
    }

    @Override
    public void postOrder() {
        if (isEmpty()) {
            System.out.println("当前二叉树为空");
        } else {
            System.out.print("二叉树后序遍历：");
            postRun(this.root);
        }
    }
    private void postRun(Node node) {
        if (node == null) {
            return;
        }
        postRun(node.left);
        postRun(node.right);
        System.out.print(node.data + " ");
    }

    @Override
    public void levelOrder() {
        if (isEmpty()) {
            System.out.println("当前二叉树为空");
        } else {
            System.out.print("二叉树层序遍历：");
            Queue<Node> queue = new LinkedList<>();
            Node node = this.root;
            queue.add(node);
            while (!queue.isEmpty()) {
                Node value = queue.poll();
                System.out.print(value.data + " ");
                if (value.left != null) {
                    queue.add(value.left);
                }
                if (value.right != null) {
                    queue.add(value.right);
                }
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E removeMin() {
        E value = getMin();
        removeMinNode(this.root);
        return value;
    }
    private Node removeMinNode(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    @Override
    public E removeMax() {
        E value = getMax();
        removeMaxNode(this.root);
        return value;
    }

    @Override
    public boolean containsNode(E e) {
        if (isEmpty()) {
            return false;
        }
        return !(contain(this.root,e) == null);
    }
    private Node contain(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.data) == 0) {
            return node;
        } else if (e.compareTo(node.data) > 0) {
            return contain(node.right,e);
        } else {
            return contain(node.left,e);
        }
    }

    private Node removeMaxNode(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxNode(node.right);
        return node;
    }
}
