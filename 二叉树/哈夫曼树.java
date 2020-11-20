package 二叉树;

import java.util.*;

public class 哈夫曼树 {

    private static class TreeNode implements Comparable<TreeNode>{
        TreeNode left;
        TreeNode right;
        int weight;
        char ch;
        String code;

        public TreeNode(int weight,TreeNode left,TreeNode right){
            this.weight = weight;
            this.left = left;
            this.right = right;
            this.code = "";
        }

        @Override
        public int compareTo(TreeNode o) {
            if(this.weight > o.weight){
                return 1;
            }else if(this.weight < o.weight){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public static TreeNode huffman(TreeMap<Integer,Character> data){
        TreeSet<TreeNode> tNodes = new TreeSet<>();
        Set<Integer> weights = data.keySet();
        Iterator<Integer> iterator = weights.iterator();
        while(iterator.hasNext()){
            int weight = iterator.next();
            TreeNode tmp = new TreeNode(weight,null,null);
            tmp.ch = data.get(weight);
            tNodes.add(tmp);
        }
        while(tNodes.size() > 1){
            TreeNode leftNode = tNodes.pollFirst();
            leftNode.code = "0";
            TreeNode rightNode = tNodes.pollFirst();
            rightNode.code = "1";
            TreeNode newNode = new TreeNode(leftNode.weight+rightNode.weight,leftNode,rightNode);
            tNodes.add(newNode);
        }
        return tNodes.first();
    }

    public static void code(TreeNode t){
        if(t.left !=null){
            t.left.code = t.code+t.left.code;
            code(t.left);
        }
        if(t.right!=null){
            t.right.code = t.code + t.right.code;
            code(t.right);
        }
    }

    public static void print(TreeNode root){
        if(root !=null){
            if(root.left == null && root.right == null){
                System.out.println(root.ch + "编码:" + root.code);
            }else{
                print(root.left);
                print(root.right);
            }
        }
    }
    public static void main(String[] args){
        TreeMap<Integer,Character> test = new TreeMap<>();
        test.put(3,'A');
        test.put(4,'B');
        test.put(10,'C');
        test.put(8,'D');
        test.put(6,'E');
        test.put(5,'F');

        TreeNode root = huffman(test);
        code(root);
        print(root);

        System.out.println("输入字符串");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printCode(s,test);
    }

    public static void printCode(String s,TreeMap<Integer,Character> data){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            TreeSet<TreeNode> tNodes = new TreeSet<>();
            Set<Integer> weights = data.keySet();
            Iterator<Integer> iterator = weights.iterator();
            while(iterator.hasNext()){
                int weight = iterator.next();
                TreeNode tmp = new TreeNode(weight,null,null);
                tmp.ch = data.get(weight);
                tNodes.add(tmp);
            }
        }

    }
}
