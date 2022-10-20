import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return res;
        }
        String[] letterlist = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(digits, 0, "", letterlist);
        return res;
    }

    public void letterCombinationsHelper(String digits, int index, String curr, String[] letterlist){
        if(index == digits.length()){
            res.add(curr);
            return;
        }else{
            String list = letterlist[digits.charAt(index)-'2'];
            for(int j = 0; j < list.length(); j++){
                curr = curr+ list.charAt(j);
                letterCombinationsHelper(digits,index+1, curr, letterlist);
                curr = curr.substring(0,curr.length()-1);
            }

        }
    }
}
