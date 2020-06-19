import java.util.LinkedList;
import java.util.Queue;

class BTNode{
    public int val;
    public BTNode left;
    public BTNode right;

    BTNode(int val){
        this.val = val;
    }
}
public class CompleteTree {
    public BTNode root = null;
    private int index = 0;
    public CompleteTree(int[] array,int invaild){
        root = buildTree(array,invaild);
    }
    private BTNode buildTree(int[] array,int invaild){
        BTNode newRoot = null;

        while (index < array.length && array[index] != invaild){
            newRoot = new BTNode(array[index]);
            ++index;
            newRoot.left = buildTree(array,invaild);
            ++index;
            newRoot.right = buildTree(array,invaild);
        }
        return newRoot;
    }
    public boolean isCompleteTree(){
        return isCompleteTree(root);
    }
    public boolean isCompleteTree(BTNode root){
        if(root == null){
            return true;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        boolean flg = false;
        while (!q.isEmpty()){
            BTNode node = q.poll();
            if(flg){
                if(node.left != null || node.right != null){
                    return false;
                }
            }else {
                if(node.right != null && node.left != null){
                    q.add(node.left);
                    q.add(node.right);
                }else if(node.left != null){
                    q.add(node.left);
                    flg = true;
                }else if(node.right != null){
                    return false;
                }else {
                    flg = true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,-1,-1,-1,4,5,-1,-1,6};
        CompleteTree completeTree = new CompleteTree(a,-1);
        System.out.println(completeTree.isCompleteTree());
    }
}
