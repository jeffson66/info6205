import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Long> queue = new LinkedList<>();
        Queue<TreeNode> record = new LinkedList<>();
        queue.add(new Long(1));
        record.add(root);
        record.add(null);
        return widthOfBinaryTreeHelper(record, 0, queue);
    }

    public int widthOfBinaryTreeHelper(Queue<TreeNode> record, int max, Queue<Long> queue){
        if(record.peek() == null){
            return max;
        }else{
            long tempMin = Long.MAX_VALUE;
            long tempMax = Long.MIN_VALUE;
            while(record.peek()!=null){
                TreeNode curr = record.poll();
                long currNum = queue.poll();
                if(curr.left != null){
                    queue.add(currNum*2);
                    record.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(currNum*2+1);
                    record.add(curr.right);
                }
                if(currNum > tempMax){
                    tempMax = currNum;
                }
                if(currNum < tempMin){
                    tempMin = currNum;
                }
            }
            record.poll();
            record.add(null);
            if(tempMax - tempMin + 1 > max){
                max = (int)(tempMax - tempMin + 1);
            }
            return widthOfBinaryTreeHelper(record, max, queue);
        }
    }
}
