package company.code.me;

import java.util.Arrays;
import java.util.List;

public class ThreeClose {

    public static void main(String[] args){
        int[] a = {-1,0,1,2,-1,-4};
        int[] w = {-1,2,1,-4};

        // List<List<Integer>> b =threeSum(a) ;
        // System.out.println(b);

        int c =threeSumClosest(w,1) ;
        int q =threeSumClosest1(w,1) ;
        System.out.println(c);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int x=nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
            int low = i+1, high = nums.length-1;
            int w=0;

            while(low<high){
                int min = nums[i]+nums[low]+nums[high];
                if(min>target) {
                    high--;
                }
                if(min<=target) {
                    low++;
                }

                if(min <=target){
                    w=target-min;
                }
                if(min >target){
                    w=min - target;
                }

                x =Math.min(w,x);
            }

        }
        return x+target;
    }

    public static int threeSumClosest1(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static int threeSumClosest2(int[] num, int target) {



        return 0;
    }
}
