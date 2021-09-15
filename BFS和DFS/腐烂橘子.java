package BFS和DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂橘子 {
    /*
    * 在给定的网格中，每个单元格可以有以下三个值之一：
    值 0 代表空单元格；
	值 1 代表新鲜橘子；
	值 2 代表腐烂的橘子。
    每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
    返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
    * 输入：[[2,1,1],[1,1,0],[0,1,1]]
        输出：4

    示例 2：
    输入：[[2,1,1],[0,1,1],[1,0,1]]
    输出：-1
    解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

    示例 3：
    输入：[[0,2]]
    输出：0
    解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0
    *
    * 题解：定义一个count表示新鲜橘子的个数，作为标记判断后面
    * 第一次遍历数组，将腐烂橘子的下标入队，作为第一层节点
    * 然后进行 BFS 遍历，定义一个round，每遍历一次，round++，遍历该结点的上下左右，同时判断是否是在边界里面，
      如果上下左右中有新鲜橘子，count--，同时该节点下标入队，该节点新鲜橘子变成腐烂橘子
    * 当count==0 && 队列为空时跳出循环，如果count==0，return round，否则return -1；
*/

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int x = orangesRotting(grid);
        System.out.println(x);
    }

    public static int orangesRotting(int[][] grid){
        int count=0;
        Queue<int[]> queue = new LinkedList<>();
        int R = grid.length;
        int C = grid[0].length;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(grid[r][c]==1)
                    count++;
                else if(grid[r][c]==2)
                    queue.add(new int[]{r,c});
            }
        }
        int round = 0;
        while(count>0 && !queue.isEmpty()){
            round++;
            int n = queue.size();
            for(int i=0;i<n;i++){
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];

                if(r-1>=0 &&grid[r-1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }
                if(c-1>=0 &&grid[r][c-1] == 1) {
                    queue.add(new int[]{r, c - 1});
                    grid[r][c - 1] = 2;
                    count--;
                }
                if(r+1<R && grid[r+1][c] == 1) {
                    queue.add(new int[]{r+1, c});
                    grid[r+1][c] = 2;
                    count--;
                }
                if(c+1<C &&grid[r][c+1] == 1){
                    queue.add(new int[]{r,c+1});
                    grid[r][c+1]=2;
                    count--;
                }
            }
        }
        if(count != 0){
            return -1;
        }
        return round;
    }
}
