package 二叉树;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode101对称二叉树 {
    /*
    给定一个二叉树，检查它是否是镜像对称的。
    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
            1
           / \
          2   2
         / \ / \
        3  4 4  3
      但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
            1
           / \
          2   2
           \   \
           3    3
           */
    //要镜像对称，终止条件：left!=right,left.val！=right.val
    //判断left.left和right.right ，left.right和right.left
    //时间复杂度时On，空间复杂度是递归的深度On
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left == null && right == null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }

    public boolean isSymmetric2(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right==null) {
                continue;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


}
