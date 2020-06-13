/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PreAndInOrder {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,in,0,in.length);
    }
    private int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in,int left,int right) {
        if(index >= pre.length || left >= right){
            return null;
        }
        TreeNode tree = new TreeNode(pre[index]);
        int i = 0;
        for(i = 0;i < in.length;i++){
            if(tree.val == in[i]){
                break;
            }
        }
        index++;
        tree.left = reConstructBinaryTree(pre,in,left,i);
        tree.right = reConstructBinaryTree(pre,in,i+1,right);
        return tree;
    }
}