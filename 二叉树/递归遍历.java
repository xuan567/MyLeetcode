package 二叉树;

public class 递归遍历 {
    //前序遍历
    public static void preOrderRecur(TreeNode head){
        System.out.print(head.val+"");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //中序遍历
    public static void inOrderRecur(TreeNode head){
        inOrderRecur(head.left);
        System.out.print(head.val);
        inOrderRecur(head.right);

    }
    //后序遍历
    public static void postOrderRecur(TreeNode head){
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val+"");
    }

}
