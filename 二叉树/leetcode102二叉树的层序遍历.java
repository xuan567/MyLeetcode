package 二叉树;

import java.util.*;

public class leetcode102二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list2 = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list2.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(list2);
        }
        return list;
    }
}
