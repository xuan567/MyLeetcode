package 二叉树;

import java.util.HashMap;

public class leetcode从前序与中序遍历序列构造二叉树 {
    /*根据一棵树的前序遍历与中序遍历构造二叉树。

    注意:
    你可以假设树中没有重复的元素。

    例如，给出

    前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]

    返回如下的二叉树：

            3
            / \
            9  20
            /  \
            15   7
     */

//    HashMap<Integer,Integer> hm = new HashMap<>();
//    int[] pre;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for(int i=0;i<inorder.length;i++){
//            hm.put(inorder[i],i);
//        }
//        pre = preorder;
//        TreeNode root = buildTree(0,inorder.length-1,0,preorder.length-1);
//        return root;
//    }
//
//    public TreeNode buildTree(int is,int ie,int ps,int pe){
//        if(is > ie || ps > pe){
//            return null;
//        }
//        int root = pre[ps];
//        int ir = hm.get(root);
//        TreeNode node = new TreeNode(root);
//        node.left = buildTree(is,ir-1,ps+1,ps+ir-is-1);
//        node.right = buildTree(ir+1,ie,ps+ir-is,pe);
//        return node;
//    }


    public TreeNode buildTree(int[] preorder,int[] inorder){
        return buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end){
        if(p_start==p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = 0;
        for(int i=i_start;i<i_end;i++){
            if(root_val == inorder[i]){
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index);
        root.right = buildTreeHelper(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end);
        return root;
    }
}
