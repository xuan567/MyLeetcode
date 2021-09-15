package 二叉树;

public class leetcode96二叉搜索树 {

    /*
    * 给你一个整数n,求恰由n个节点组成且节点值
    * 从1到n互不相同的二叉搜索树有多少种？返回满足题意的二叉搜索树的种数。

        示例 1：
        输入：n = 3
        输出：5

        示例 2：
        输入：n = 1
        输出：1
    * */

    //题解：
    //动态规划
    //假设n个节点存在二叉排序树的个数是 G (n)，令f(i)为以i为根的二叉搜索树的个数
    //G(n) = f(1)+f(2)+f(3)+f(4)
    //当i为根节点时，左子树节点个数i-1，右子树节点个数n-i
    //f(i) = G(i-1)*G(n-i)
    //得到卡特兰数公式：G(n) = G(0)*G(N-1) + G(1)*G(N-1) + ... G(N-1)*G(0)
    //

    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                G[i] += G[j-1] *G[i-j];
            }
        }
        return G[n];
    }
}
