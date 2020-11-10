package 二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode297二叉树的序列化与反序列化 {
    /*
    * 297. 二叉树的序列化与反序列化
        序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
        同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
        反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
        示例:
        你可以将以下二叉树：

            1
           / \
          2   3
             / \
            4   5

        序列化为 "[1,2,3,null,null,4,5]"*/
    // Encodes a tree to a single string.

    public String reserialize(TreeNode root,String s){
        if(root==null){
            s+="None,";
        }else{
            s += String.valueOf(root.val)+",";
            s = reserialize(root.left,s);
            s = reserialize(root.right,s);
        }
        return s;
    }
    public String serialize(TreeNode root) {
        return reserialize(root,"");
    }

    // Decodes your encoded data to tree.

    public TreeNode redeserialize(List<String> l){
        if(l.get(0).equals("None")){
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = redeserialize(l);
        node.right = redeserialize(l);
        return node;
    }
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return redeserialize(data_list);
    }
}
