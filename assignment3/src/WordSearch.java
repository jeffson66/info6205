import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, word, i, j , 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }else if(row >= board.length || row < 0 || col >= board[0].length || col < 0){
            return false;
        }else if(word.charAt(index) != board[row][col] || board[row][col] == '!'){
            return false;
        }else{

            int up = row-1;
            int down = row+1;

            int left = col-1;
            int right = col+1;
            char keep = board[row][col];
            board[row][col] = '!';
            boolean res = exist(board, word, row,left, index+1)||
                    exist(board, word, row,right, index+1)||
                    exist(board, word, up,col, index+1)||
                    exist(board, word, down, col, index+1);


            board[row][col] = keep;
            return res;
        }
    }
}
