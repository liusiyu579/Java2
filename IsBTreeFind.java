public class IsBTreeFind {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return func(sequence,0,sequence.length-1);
    }
    public boolean func(int [] sequence,int start,int end) {
         if(end <= start){
             return true;
         }   
        int i = start;
		// 找到根节点的左子树的临界点
        for(;i < end;i++){
            if(sequence[i] > sequence[end]){
                break;
            }
        }
		// 如果右子树的节点比根节点小 那就是false
        for(int j = i;j < end;j++){
            if(sequence[j] < sequence[end]){
                return false;
            }
        }
		// 递归检查左子树 右子树是否满足
        return func(sequence,start,i-1) && func(sequence,i,end-1);
    }
}