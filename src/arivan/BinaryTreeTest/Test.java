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

        binaryTree.preOrder();
        System.out.println();
        binaryTree.remove(3);
        binaryTree.inOrder();
        System.out.println();

//        System.out.println(binaryTree.containsNode(1));
//        System.out.println(binaryTree.size());
//        binaryTree.preOrder();
//        System.out.println();
//        System.out.println(binaryTree.getMax());
//        System.out.println(binaryTree.getMin());
//
//        binaryTree.removeMax();
//        binaryTree.removeMin();
//        System.out.println(binaryTree.getMax());
//        System.out.println(binaryTree.getMin());
//        binaryTree.preOrder();
//        System.out.println();
//        binaryTree.inOrder();
//        System.out.println();
//        binaryTree.postOrder();
//        System.out.println();
//        binaryTree.levelOrder();
//        System.out.println();
//
//        System.out.println(binaryTree.containsNode(1));
//        System.out.println(binaryTree.containsNode(8));
    }
}
