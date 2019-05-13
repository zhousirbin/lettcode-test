package company.linkedlist;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ListTest {
    public static void main(String[] args){
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        Long a= list.remove(1);
        System.out.println(list.toString());

        HashMap<String,String> hashMap = new HashMap<>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();

        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word ="ABCCED";
        exist(chars,word);

        ListTest listTest = new ListTest();
        String word1 ="SEE";
        listTest.exist1(chars,word1);

    }

    public static boolean exist(char[][] board, String word) {
        int len =board.length;
        int len1 =board[0].length;
        int len2=word.length();
        List<Character> list = new ArrayList<>();

        // char[] c = new char[len*len1];
        for(int i=0;i<len;i++){

            for(int j=0;j<len1;j++){
                list.add(board[i][j]);
            }
        }

        for(int j=0;j<len2;j++){

            if(list.contains(word.charAt(j))){
                System.out.println(word.charAt(j));
                list.remove((Character )word.charAt(j));
            }else{
                return false;
            }

        }
        return true;
    }

    public  boolean exist1(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;//返回什么也不做
        board[y][x] ^= 256;
        System.out.println(board[y][x]);
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }


}
