package arivan.BinaryTreeTest;

public interface BinaryTree<E> {
    /**
     * 向二叉树中插入数据
     * @param e 需要插入的数据
     */
    void add(E e);

    /**
     * 删除二叉树中的数据
     * @param e 需要删除的数据
     * @return 返回是否成功删除
     */
    boolean remove(E e);

    /**
     * 取得二叉树中最大元素
     * @return 返回最大元素
     */
    E getMax();

    /**
     * 取得二叉树中最小的元素
     * @return 返回最小元素000
     */
    E getMin();

    /**
     * 二叉树前序遍历
      */
    void preOrder();

    /**
     * 二叉树中序遍历
     */
    void inOrder();

    /**
     * 二叉树后序遍历
     */
    void postOrder();

    /**
     * 二叉树的层序遍历
     */
    void levelOrder();

    /**
     * 取得当前节点的数量
     * @return 返回节点的数目
     */
    int size();

    /**
     * 判断当前二叉树是否为空
     * @return
     */
    boolean isEmpty();
}
