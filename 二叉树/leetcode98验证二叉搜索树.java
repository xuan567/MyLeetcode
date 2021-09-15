package 二叉树;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode98验证二叉搜索树 {
    /*
    *   给定一个二叉树，判断其是否是一个有效的二叉搜索树。
        假设一个二叉搜索树具有如下特征：

        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。

        示例1:
        输入:
            2
           / \
          1   3
        输出: true

        示例2:
        输入:
            5
           / \
          1   4
             / \
            3   6
        输出: false
        解释: 输入为: [5,1,4,null,null,3,6]。
        根节点的值为 5但是其右子节点值为 4 。

    * */

    // 题解1：递归
    // 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
    // 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
    // 它的左右子树也为二叉搜索树。
    // 设计一个递归函数 helper(root, lower, upper) 来递归判断
    // 在递归调用左子树时，我们需要把上界 upper 改为 root.val
    // 调用右子树时，我们需要把下界 lower 改为 root.val
    //

    public static void main(String[] args) {
        System.out.println(0 > -Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }
        if(root.val <= minValue || root.val >= maxValue){
            return false;
        }
        return isValidBst(root.left,minValue,root.val) && isValidBst(root.right, root.val, maxValue);
    }

    //题解2：中序遍历
    //中序遍历 二叉搜索树得到的序列是升序序列
    //所以判断遍历的当前节点大于上一个节点是一个升序序列

    public boolean isValidBST2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        for(int i=1;i<res.size();i++){

            if(res.get(i)<=res.get(i-1)){
                return false;
            }
        }
        return true;
    }

    //题解里的中序遍历

    public boolean isValidBST3(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
