import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class FindTreePath {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null){
            return ret;
        }
        int sum = 0;  // 计算当前节点的和
        int index = 0; // 从根路径到当前节点，所走过的节点总数
        int[] path = new int[50];  // 记录走过的路径节点
        ps(root,target,sum,index,path);
        return ret;
    }
    public void ps(TreeNode root,int target,int sum,int index,int[] path){
        if(root == null){
            return;
        }
		// 把该节点包含进去
        sum+=root.val;
        path[index] = root.val;
        index ++;
		// 已经走到叶子结点，并且sum已经等于目标和
        if(sum == target && root.left == null && root.right == null){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0;i <index ;i++){
                list.add(path[i]);
            }
            ret.add(list);
        }
		// 目标和还不够，继续走左节点
        if(sum < target && root.left != null){
            ps(root.left,target,sum,index,path);
        }
		// 目标和还不够，继续走右节点
        if(sum < target && root.right != null){
            ps(root.right,target,sum,index,path);
        }
    }
}