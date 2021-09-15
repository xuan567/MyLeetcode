package 二叉树;

public class leetcode110平衡二叉树 {
    /*
    * 110. 平衡二叉树难度简单505给定一个二叉树，判断它是否是高度平衡的二叉树。
            本题中，一棵高度平衡二叉树定义为：
            一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
            示例 1:
            给定二叉树 [3,9,20,null,null,15,7]

                3
               / \
              9  20
                /  \
               15   7

            返回 true

            示例 2:
            给定二叉树 [1,2,2,3,3,null,null,4,4]

                   1
                  / \
                 2   2
                / \
               3   3
              / \
             4   4
            返回 false 。
            */
    //题解：递归方法，
    // 1.从上向下，类似于前序遍历，对于当前遍历的结点，首先计算左右子树的高度，如果左右子树的高度差不超过1，
    //  再分别遍历左右子节点，判断左右子树是否是平衡子树自上而下的递归
    // 2.自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
    //   再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度
    //   否则返回 −1-1−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
    //
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return false;
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.right)&&isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }


}
