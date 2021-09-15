package 二叉树;

public class leetcode226翻转二叉树 {
    /*
    翻转一棵二叉树。
    示例：
    输入：

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    输出：

         4
       /   \
      7     2
     / \   / \
    9   6 3   1

        * */

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        def(root);
        return root;
    }

    private void def(TreeNode root){
        if(root==null){
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        def(root.left);
        def(root.right);
    }
}
