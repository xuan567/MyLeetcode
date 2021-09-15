package 动态规划;

public class leetcode72编辑距离 {
    /*
    * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
        你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符

        示例1：
        输入：word1 = "horse", word2 = "ros"
        输出：3
        解释：
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')

        示例2：
        输入：word1 = "intention", word2 = "execution"
        输出：5
        解释：
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')

    * */

    //题解：
    //dp[i][j]表示word1到i位置转换成word2到j位置需要最少步数
    //插入操作：比较 word1[0..i]和word2[0..j-1]的结果
    //删除操作：比较 word1[0..i-1]和word2[0..j]的结果
    //替换操作：比较 word1[0..i-1]和word2[0..j-1]的结果
    //

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n2;i++){
            dp[0][i] = dp[0][i-1]+1;
        }
        for(int j=1;j<=n1;j++){
            dp[j][0] = dp[j-1][0]+1;
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }

        return dp[n1][n2];
    }
}
