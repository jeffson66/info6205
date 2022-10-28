import java.util.LinkedList;
import java.util.Queue;

public class SerializedandDeserializeBST {
    Queue<String> track;
    public String serialize(TreeNode root) {
        track = new LinkedList<>();
        serialize(root, track);
        String res = "";
        while(!track.isEmpty()){
            res = res + track.poll() + ",";
        }
        return res;
    }

    public void serialize(TreeNode root, Queue<String> track){
        if(root == null){
            track.add("#");
        }else{
            track.add(root.val+"");
            serialize(root.left, track);
            serialize(root.right, track);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strlist = data.split(",");
        for(String str: strlist){
            track.add(str);
        }
        return deserialize(track);
    }

    public TreeNode deserialize(Queue<String> track){
        String curr = track.poll();
        if(curr.equals("#")){
            return null;
        }else{
            int val = Integer.parseInt(curr);
            TreeNode root = new TreeNode(val);
            root.left = deserialize(track);
            root.right = deserialize(track);
            return root;
        }
    }
}
