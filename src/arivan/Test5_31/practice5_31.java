package arivan.Test5_31;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class practice5_31 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Solution1 solution1 = new Solution1();
    }
}

//二叉树的前序遍历
class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}

//二叉树的中序遍历
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        run(root,list);
        return list;
    }
    private void run(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } else {
            run(node.left,list);
            list.add(node.val);
            run(node.right,list);
        }
    }
}

//二叉树的后序遍历
class Solution2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        run(root,list);
        return list;
    }
    private void run(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        run(root.left,list);
        run(root.right,list);
        list.add(root.val);
    }
}

//根据二叉树创建字符串
class Solution3 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public String tree2str(TreeNode t) {
        StringBuilder str = new StringBuilder();
        if (t == null) {
            return str.toString();
        }
        run(t,str);
        return str.toString();
    }
    private void run(TreeNode node, StringBuilder str) {
        if (node == null) {
            return;
        }
        str.append(node.val);
        if (node.left != null) {
            str.append("(");
            run(node.left,str);
            str.append(")");
        } else {
            if (node.right != null) {
                str.append("()");
            }
        }
        if (node.right != null) {
            str.append("(");
            run(node.right,str);
            str.append(")");
        }
    }
}