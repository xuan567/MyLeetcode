package 二叉树;

public class leetcode104二叉树的最大深度 {
    /*
    * 104. 二叉树的最大深度难度简单728收藏分享切换为英文接收动态反馈给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        说明: 叶子节点是指没有子节点的节点。
        示例：
        给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
          9  20
            /  \
           15   7
        */
    //DFS:终止条件：当前节点为空，return 0，
    // 当节点不为空时，求出左右子树的最大高度再加上自身，加1，返回该值
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
