import java.util.ArrayList;

public class NumbersWirthSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> curr = new ArrayList<>();
        for(int i = 1; i <=9; i++){
            numsSameConsecDiff(n-1, k, curr, String.valueOf(i));
        }
        int[] res = new int[curr.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = curr.get(i);
        }
        return res;
    }

    public void numsSameConsecDiff(int n, int k, ArrayList<Integer> curr, String current){
        if(n == 0){
            int temp = Integer.parseInt(current);
            curr.add(temp);

        }else{
            int temp = current.charAt(current.length()-1)-'0'-k;
            if(temp >= 0){
                numsSameConsecDiff(n-1, k,curr, current+(current.charAt(current.length()-1)-'0'-k));
            }
            if(current.charAt(current.length()-1)-'0' + k <= 9 && current.charAt(current.length()-1)-'0' + k !=temp){
                numsSameConsecDiff(n-1, k,curr, current+(current.charAt(current.length()-1)-'0'+k));
            }


        }
    }
}
