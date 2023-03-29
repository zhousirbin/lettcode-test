package company.code.me;

public class RemoveDupliute {

    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
         for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
