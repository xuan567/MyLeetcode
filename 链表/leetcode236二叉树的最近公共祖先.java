package 链表;

import 二叉树.TreeNode;

public class leetcode236二叉树的最近公共祖先 {
    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
    最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
    （一个节点也可以是它自己的祖先）。”

    示例 1：
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出：3
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

    示例 2：
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出：5
    解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

    示例 3：
    输入：root = [1,2], p = 1, q = 2
    输出：1
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //当left和right同时为空：说明root的左/右子树中都不包含p,q，返回null ；
        if(left==null && right == null){
            return null;
        }
        //当left空,right 不为空：p,q都不在root的左子树中，直接返回right
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }

        //当left和right同时不为空 ：说明p, q分列在root的异侧 分别在左/右子树），
        //因此root最近公共祖先，返回root ；
        return root;
    }

    class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

}
