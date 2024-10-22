import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            long levelSum = 0L;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                levelSum += cur.val;
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            
            level++;
            pq.offer(levelSum);
            if(pq.size() > k){
                pq.poll();
            }
        }
      
        if(pq.size() < k) {
            return -1;
        }
        return pq.peek();
    }
}