package company.code.me;

import java.util.concurrent.ConcurrentHashMap;

public class JumpGame2 {

    public static void main(String[] args){

        int[] a = {2,3,1,1,4};
        jump(a);
        System.out.println(a);

        ConcurrentHashMap concurrentHashMap =null;
    }

    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static int jump1(int[] A){
        int jumps =0, curEnd = 0, curFarthest =0;
        for (int i = 0;i< A.length-1;i++){
            curFarthest = Math.max(curFarthest, i+A[i]);

            if (i==curEnd){
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }


}
