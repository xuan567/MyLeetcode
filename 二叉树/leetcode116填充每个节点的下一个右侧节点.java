package 二叉树;

import java.util.LinkedList;

public class leetcode116填充每个节点的下一个右侧节点 {
    /*
    * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
        struct Node {
          int val;
          Node *left;
          Node *right;
          Node *next;
        }
    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    初始状态下，所有 next 指针都被设置为 NULL。

    示例：
    输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},
         "next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":
         null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},
         "next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
    输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,
         "next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},
         "right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":
         {"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":
         null,"right":{"$ref":"7"},"val":1}
*/

    //递归解法1
    //层序遍历，将每一层都加入队列，前一个的next都指向最后一个
    //当一层遍历完后，出队，再遍历下一层
    //时间复杂度： O(n)
    //空间复杂度： O(n)

    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            Node tmp = queue.get(0);
            for(int i=1;i<size;i++){
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            for(int i=0;i<size;i++){
                tmp = queue.remove();
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }

    //串联的节点：1.有一个共同的父节点。通过这个父节点将两个子节点串联起来
    //          2.串联的父节点不同，将上一层串联好，可以通过父节点的next找到邻居，完成串联
    //时间复杂度：O(n)O(n)
    //空间复杂度：O(1)O(1)

    public Node connect2(Node root){
        if(root == null){
            return null;
        }
        Node pre = root;
        while(pre.left!=null){
            Node tmp = pre;
            while(tmp!=null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }

    //递归
    //以当前节点root为起始，左右节点不断地深入下面，left节点不断往右走，right节点不断往左走，
    // 当这两个节点走到底后，整个纵深这段就完成了串联。终止条件：当前节点为空时。
    //时间复杂度：O(n)O(n)
    //空间复杂度：O(h)O(h)，hh 是树的高度

    public Node connect3(Node root) {
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        Node left = root.left;
        Node right = root.right;

        while(left!=null){
            left.next = right;
            left = left.right;
            right = right.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
