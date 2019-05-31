package arivan.BinaryTreeTest;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinSearchTree<>();
        binaryTree.add(5);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(9);
        binaryTree.add(9);
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.getMax());
        System.out.println(binaryTree.getMin());
    }
}
