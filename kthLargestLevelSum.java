import java.util.Collections;
import java.util.List;  
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>q=new LinkedList<>();
         if(root==null){
            return 0;
        }
        q.add(root);
         List<Long>level=new ArrayList<>();
        while(!q.isEmpty()){
            long t=0;
            int n=q.size();
            for(int i=0;i<n;i++){
            TreeNode temp=q.poll();
            t=t+temp.val; 
            if(temp.right!=null){
                q.add(temp.right);
            }
           if(temp.left!=null){
                q.add(temp.left);
            }
            }
            level.add(t);
        }
    Collections.sort(level, Collections.reverseOrder());
         if(k>level.size()){
            return -1;
         }
         return level.get(k-1);
    }
}
