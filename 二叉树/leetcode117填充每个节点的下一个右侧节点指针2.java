package 二叉树;

import java.util.LinkedList;

public class leetcode117填充每个节点的下一个右侧节点指针2 {
    /*
    * 给定一个二叉树
        struct Node {
          int val;
          Node *left;
          Node *right;
          Node *next;
        }
      填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。*/

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            Node temp = queue.get(0);
            for(int i=1;i<size;i++){
                temp.next = queue.get(i);
                temp = queue.get(i);
            }
            for(int i=0;i<size;i++){
                temp = queue.remove();
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root){
        if(root==null){
            return null;
        }
        Node cur = root;
        while(cur!=null){
            Node dummy = new Node(0);
            Node pre = dummy;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}
