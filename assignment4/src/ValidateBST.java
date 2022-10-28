import java.util.ArrayList;

public class ValidateBST {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        order(root, list);
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        for(int i = 0; i < arr.length; i++){
            int curridx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[curridx]){
                    curridx = j;
                }
            }
            int temp = arr[curridx];
            arr[curridx] = arr[i];
            arr[i] = temp;
        }
        recover(root, arr, list);

    }
    public void recover(TreeNode curr, int[] arr, ArrayList<Integer> list){
        if(curr == null){
            return;
        }
        int index = 0;
        for(int i: list){
            if(curr.val == i){
                break;
            }else{
                index++;
            }
        }
        curr.val = arr[index];
        recover(curr.left, arr, list);
        recover(curr.right, arr, list);

    }

    public void order(TreeNode curr, ArrayList<Integer> list){
        if(curr == null){
            return;
        }
        order(curr.left, list);
        list.add(curr.val);
        order(curr.right, list);
    }
}
