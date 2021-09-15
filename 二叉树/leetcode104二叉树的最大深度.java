package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public int maxDepth1(TreeNode root) {
        if(root==null)
            return 0;
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left,right)+1;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;
    }

    public int maxDepth3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root,res);
        return res.size();
    }

    private void levelOrder(TreeNode root,List<List<Integer>> res){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i < size;i++){
                TreeNode node = stack.poll();
                if(node.left!=null){
                    stack.add(node.left);
                }
                if(node.right!=null){
                    stack.add(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
        }
    }

}
