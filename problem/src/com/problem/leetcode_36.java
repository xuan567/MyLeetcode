package com.problem;

import java.util.HashMap;

public class leetcode_36 {
	/*判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
	数字 1-9 在每一行只能出现一次。
	数字 1-9 在每一列只能出现一次。
	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	示例 1:
	输入:
	[
	  ["5","3",".",".","7",".",".",".","."],
	  ["6",".",".","1","9","5",".",".","."],
	  [".","9","8",".",".",".",".","6","."],
	  ["8",".",".",".","6",".",".",".","3"],
	  ["4",".",".","8",".","3",".",".","1"],
	  ["7",".",".",".","2",".",".",".","6"],
	  [".","6",".",".",".",".","2","8","."],
	  [".",".",".","4","1","9",".",".","5"],
	  [".",".",".",".","8",".",".","7","9"]
	]
	输出: true*/

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','7','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};

		
	}
    public static boolean isValidSudoku(char[][] board) {
    	HashMap<Integer,Integer>[] rows = new HashMap[9];
    	HashMap<Integer,Integer>[] columns = new HashMap[9];
    	HashMap<Integer,Integer>[] boxes = new HashMap[9];
    	for(int i=0;i<9;i++) {
    		rows[i]=new HashMap<Integer,Integer>();
    		columns[i]=new HashMap<Integer,Integer>();
    		boxes[i]=new HashMap<Integer,Integer>();
    	}
    	for(int i=0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			if('.'!=board[i][j]) {
	    			int boxes_index = (i/3)*3+j/3;
	    			int n =(int) board[i][j];
	    			rows[i].put(n, rows[i].getOrDefault(n, 0)+1);
	    			columns[j].put(n, columns[j].getOrDefault(n, 0)+1);
	    			boxes[boxes_index].put(n, boxes[boxes_index].getOrDefault(n, 0)+1);
	    			if(rows[i].get(n)>1||columns[j].get(n)>1||boxes[boxes_index].get(n)>1)
	    				return false;
    			}
    		}
    	}
    	return true;
    }
}

/*将大数独分为九个子数独，要确保行，列，子数独都没有重复的数字，用HashMap来记录，
 * 子数独的索引就等于(rows/3)*3+j/3 ,遍历数独，每一次都检查，如果出现重复，
 * 返回false如果没有，就记录此值，之后检查时会用到，最后返回true*/
