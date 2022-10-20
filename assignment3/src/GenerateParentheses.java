import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n, n, "", res);
        return res;
    }

    public void generateParenthesis(int front, int back, String curr, List<String> res){
        if(back == 0){
            res.add(curr);
        }
        if(front > 0){
            generateParenthesis(front-1, back, curr+"(", res);
        }
        if(back > front){
            generateParenthesis(front, back-1, curr+")", res);
        }
    }
}
