package company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

    public static void main(String[] args){

        String a = convert("PAYPALISHIRING",4);
        System.out.println(a);

    }
        public static String convert(String s, int numRows) {

            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++)
                rows.add(new StringBuilder());

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder ret = new StringBuilder();

//            for (StringBuilder row : rows) ret.append(row);

            rows.forEach(ret::append);

            return ret.toString();
        }

    public static String convert1(String s, int numRows) {

        if(s.length() == 1) return s;

        List<StringBuilder> list = new ArrayList<>();

        for (int i=0;i< Math.min(s.length(),numRows);i++){

            list.add(new StringBuilder());

        }

        int curRow = 0;

        boolean goingDown = false;

        for (char c: s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1) goingDown=true;

            curRow += goingDown? -1:1;


        }

        StringBuffer stringBuffer =  new StringBuffer();

        list.forEach(stringBuffer::append);

        return  stringBuffer.toString();

    }


}
