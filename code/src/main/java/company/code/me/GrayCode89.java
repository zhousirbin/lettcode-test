package company.code.me;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {

    //Input: 2
    //Output: [0,1,3,2]
    //Explanation:
    //00 - 0
    //01 - 1
    //11 - 3
    //10 - 2
    public static void main(String[] args){

        grayCode(3);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);//1左移位 或 原来的值,
        }
        return rs;
    }

    public static List<Integer> grayCode1(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for (int i=0;i<n;i++){
            int size = rs.size();
            for (int j=0;j<size;j++){
                rs.add(rs.get(j) | 1<<i);
            }
        }
        return rs;
    }
}
