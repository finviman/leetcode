package own.puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 输出二叉树的左侧投影，或右侧。
 * Created by liyang on 5/27/21.
 * liyang70@meituan.com;
 */
public class BinaryTreeLeftView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(6);
        TreeNode lll = new TreeNode(7);
        TreeNode llr = new TreeNode(8);
        root.left = l;
        root.right = r;
        root.left.left = ll;
        root.left.right = lr;
        root.right.left = rl;
        root.right.right = rr;
        root.left.left.left = lll;
        root.left.left.right = llr;

        final List<Integer> integers = brandIterate(root);
        integers.forEach(System.out::println);
    }

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int n) {
            this.value = n;
        }
    }

    private static List<Integer> brandIterate(TreeNode root) {
        if (root==null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> supportQ = new ArrayDeque<>();
        supportQ.add(root);
        TreeNode node = null;
        while ((node = supportQ.poll()) != null) {
            result.add(node.value);
            if (node.left != null) {
                supportQ.add(node.left);
            }
            if (node.right != null) {
                supportQ.add(node.right);
            }
        }
        return result;
    }
}
