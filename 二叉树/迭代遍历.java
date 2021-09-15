package 二叉树;

import java.util.Stack;

public class 迭代遍历 {
    //前序遍历
    public static void preOrderIteration1(TreeNode head){
        if(head==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val+"");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
    //中序遍历
    public static void inOrderIteration(TreeNode head){
        if(head==null){
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();

        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            System.out.println(node.val+"");

            if(node.right!=null){
                cur = node.right;
            }
        }
    }
    //后序遍历
    public static void postOrderIteration1(TreeNode head){
        if(head==null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(head);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null) {
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().val+" ");
        }
    }

    public static void postOrderIteration2(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                System.out.print(stack.pop().val + " ");
                cur = peek;
            }
        }
    }

}
