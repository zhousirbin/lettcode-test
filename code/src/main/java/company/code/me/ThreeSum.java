package company.code.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args){
        int[] a = {-1,0,1,2,-1,-4};
        int[] w = {0,0,0,0};
       // List<List<Integer>> b =threeSum(a) ;
       // System.out.println(b);

        List<List<Integer>> c =threeSum1(w) ;
        System.out.println(c);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int sum=0;
        List<List<Integer>> zlist=new ArrayList<List<Integer>>();
        List<Integer> list = null;
        for(int i=0;i<nums.length-2;i++){

            for(int j=1;j<nums.length-1;j++){
                list =new ArrayList();
                for(int k=2;k<nums.length;k++){

                    if(nums[i]+nums[j]+nums[k]==0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                    }
                    zlist.add(list);
                }
            }

        }
        return zlist;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> zlist=new ArrayList<>();
        List<Integer> list = null;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {  //如果临近的值，则可以直接跳过
                int a=nums[i];
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - a;
                while (low < high) {
                    if (nums[high] + nums[low] == sum) {
                        List<Integer> list1 = Arrays.asList(a, nums[high], nums[low]);
                        zlist.add(list1);
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[high] + nums[low] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return zlist;
    }

    public List<List<Integer>> three3Sum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
