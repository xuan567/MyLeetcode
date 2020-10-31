package com.problem;

import java.util.HashMap;

public class leetcode_36 {
	/*�ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
	ʾ�� 1:
	����:
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
	���: true*/

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

/*����������Ϊ�Ÿ���������Ҫȷ���У��У���������û���ظ������֣���HashMap����¼��
 * �������������͵���(rows/3)*3+j/3 ,����������ÿһ�ζ���飬��������ظ���
 * ����false���û�У��ͼ�¼��ֵ��֮����ʱ���õ�����󷵻�true*/
