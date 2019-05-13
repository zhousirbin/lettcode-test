package company.annotion;

import java.util.ArrayList;
import java.util.List;

@TypeAnnotion
public class AnnotionTest {

    @MethodAnnotion
    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }


    @MethodAnnotion
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


}
