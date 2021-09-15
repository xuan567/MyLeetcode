package 二叉树;

public class leetcode124二叉树中的最大路径和 {
    /*
     路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     路径和 是路径中各节点值的总和。
     给你一个二叉树的根节点 root ，返回其 最大路径和 。

    示例 1：
    输入：root = [1,2,3]
    输出：6
    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6

    示例 2：
    输入：root = [-10,9,20,null,null,15,7]
    输出：42
    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

    * */

    //题解：递归
    //定义dfs函数：
    //路径停在当前子树的根节点，在这个子树中收益：root.val
    //走入左子树，在这个子树中的最大收益：root.val + dfs(root.left)
    //走入右子树，在这个子树中的最大收益：root.val + dfs(root.right)
    //父节点而言的三种选择，最大收益取最大值：root.val + max(dfs(root.left), dfs(root.right))
    //一条从父节点延伸下来的路径，不能走入左子树又掉头走右子树，不能两头收益，路径会重叠。
    //一个子树内部的最大路径和 = dfs(root.left) + root.val + dfs(root.right)
    //

    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, root.val+right+left);
        int max = Math.max(root.val+left,root.val+right);
        return max<0?0:max;
    }
}
