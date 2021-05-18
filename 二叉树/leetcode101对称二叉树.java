package 二叉树;

import java.util.*;

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
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null){
            return false;
        }
        if(right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }

        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
