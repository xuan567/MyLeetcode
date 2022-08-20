package 二叉树;

import java.util.*;

public class leetcode94二叉树的中序遍历 {

    //解法1：递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res,root);
        return res;
    }

    private void inorder(List<Integer> res,TreeNode root){
        if(root==null){
            return;
        }
        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }

    //解法2：迭代
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}

