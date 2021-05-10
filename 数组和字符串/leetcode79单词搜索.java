package 数组和字符串;

public class leetcode79单词搜索 {
    /*
    * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
    * 如果word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。

    示例 1：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true

    示例 2：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    输出：true

    示例 3：
    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    输出：false

    * */

    //题解：回溯算法，深度优先遍历和状态重置
    //int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};表示上下左右的方向
    //boolean[][] used = new boolean[rows][cols];表示是否使用过这个字母
    //
    //

//    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        boolean b  = exist(board,word);
//        System.out.println(b);
//    }

    private char[][] board;
    private boolean[][] visited;
    private char[] arr;
    private int rows,cols,len;
    private static final int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};

    public  boolean exist(char[][] board, String word) {
       this.board = board;
       rows = board.length;
       if(rows==0){
           return false;
       }
       cols = board[0].length;
       len = word.length();
       arr = word.toCharArray();
       visited = new boolean[rows][cols];

       for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){
               if(dfs(i,j,0)){
                   return true;
               }
           }
       }
       return false;
    }

    private boolean dfs(int x,int y,int begin){
        if(begin == len-1){
            return arr[begin] == board[x][y];
        }
        if(arr[begin] == board[x][y]){
            visited[x][y] = true;
            for(int[] dir:direction){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(inArea(newX ,newY) && !visited[newX][newY]){
                    if(dfs(newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x,int y){
        return x>=0 && x<rows && y>=0 && y<cols;
    }
}
