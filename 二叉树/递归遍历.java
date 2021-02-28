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
    /*
    * 两个链表都是逆序存储，两个链表中同一位置的数字可以直接相加。遍历两个链表，逐位计算它们的和，
    * 并与当前位置的进位值相加。当前的两位加上进位%10，下个进位/10
    * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个0*/

    /*
    * 遍历数组中的每一个数x，寻找数组中是否存在 target-x。每一个位于x之前的元素都已经和
    x匹配过，因此不需要再进行匹配。只需要在x后面的元素中寻找target-x。
*/

}
