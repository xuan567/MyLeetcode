package 二叉树;

import java.util.*;

public class 哈夫曼树 {

    private static class TreeNode implements Comparable<TreeNode>{
        //定义TreeNode节点，ch保存相应的字符，code保存0或1
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
    //这里用了一个TreeSet的容器节点，因为它自带排序功能（前提是对象为Comparable的子类）
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

    //得到字符编码

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
    //打印字符编码结果

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Character> test = new TreeMap<>();
        for(int i=0;i<n;i++) {
            int x = sc.nextInt();
            char ch = sc.next().charAt(0);
            test.put(x,ch);
        }
        TreeNode root = huffman(test);
        code(root);
        print(root);
        Coding(root);
    }

    public static HashMap<Character,String> hm = new HashMap<>();
    public static HashMap<String,Character> hm2 = new HashMap<>();
    public static void Coding(TreeNode root){
        //编码
        //输入要进行编码的字符串
        System.out.println("输入要进行编码的字符串");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb1 = new StringBuilder();
        traverseTree(root);
        for(int i=0;i<s.length();i++){
            sb1.append(hm.get(s.charAt(i)));
        }
        System.out.println(sb1.toString());

        //译码
        //输入要进行译码的编码串
        for (Map.Entry<Character,String> entry : hm.entrySet()) {
            hm2.put(entry.getValue(),entry.getKey());
        }
        System.out.println("输入要进行译码的编码串");
        List<Character> list = new ArrayList<Character>();
        String l = sc.next();

        for(int i=0;i<l.length();){
            int count =1;
            boolean flag = true;
            Character b = null;
            while(flag){
                String key = l.substring(i,i+count);
                b = hm2.get(key);
                if(b==null){
                    count++;
                }else{
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        char[] bytes = new char[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        System.out.println(new String(bytes,0,bytes.length));

    }

    //将所有字母及其所对应的二进制编码存入哈希表里

    public static void traverseTree(TreeNode root){
        if(root==null){
            return;
        }
        hm.put(root.ch,root.code);
        traverseTree(root.left);
        traverseTree(root.right);
    }


}
/**
 6
3 A
4 B
10 C
8 D
6 E
5 F
BEE
0010000100111101
 */