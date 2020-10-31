package com.problem;

public class leetcode_345 {
	/*345. 反转字符串中的元音字母难度简单112编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
	示例 1：	
	输入："hello"
	输出："holle"
	
	示例 2：
	输入："leetcode"
	输出："leotcede"*/

	public static void main(String[] args) {
		String s = "aA";
		String t = reverseVowels(s);
		System.out.println(t);

	}
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int i=0,j=s.length()-1;
        while(i<j) {
        	if((arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='O'||arr[i]=='I'||arr[i]=='U')&&
            		(arr[j]=='a'||arr[j]=='e'||arr[j]=='i'||arr[j]=='o'||arr[j]=='u'||arr[j]=='A'||arr[j]=='E'||arr[j]=='I'||arr[j]=='O'||arr[j]=='U')) {
            		char c = arr[i];
            		arr[i]=arr[j];
            		arr[j]=c;
            		i++;
            		j--;
            	}
        	else if((arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='O'||arr[i]=='I'||arr[i]=='U')&&
            		(arr[j]!='a'&&arr[j]!='e'&&arr[j]!='i'&&arr[j]!='o'&&arr[j]!='u'&&arr[j]!='A'&&arr[j]!='E'&&arr[j]!='O'&&arr[j]!='I'&&arr[j]!='U')) {
        		j--;
        	}else if((arr[j]=='a'||arr[j]=='e'||arr[j]=='i'||arr[j]=='o'||arr[j]=='u'||arr[j]=='A'||arr[j]=='E'||arr[j]=='I'||arr[j]=='O'||arr[j]=='U')&&
            		(arr[i]!='a'&&arr[i]!='e'&&arr[i]!='i'&&arr[i]!='o'&&arr[i]!='u'&&arr[i]!='A'&&arr[i]!='E'&&arr[i]!='I'&&arr[i]!='O'&&arr[i]!='U')) {
        		i++;
        	}else {
        		i++;
        		j--;
        	}
        }
        StringBuffer sb = new StringBuffer();
        for(i=0;i<arr.length;i++)
        	sb.append(arr[i]);
        return sb.toString();
    }
/* 将字符串转化成数组 i=0,j=arr.length-1;
 * 1.arr[i]与arr[j]都是元音字母，交换，i++，j--；
 * 2.arr[i]是,arr[j]不是,i不变，j--；
 * 3.arr[i]不是,arr[j]是,i++，j不变；
 * 若i>j则跳出循环，定义StringBuilder，sb.append(arr[i]),sb.toString();
 */
   

}
