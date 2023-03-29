package company.code.me;

public class Binary96 {



    //The problem can be solved in a dynamic programming way. I’ll explain the intuition and formulas in the following.
    //
    //Given a sequence 1…n, to construct a Binary Search Tree (BST) out of the sequence, we could enumerate each number i in the sequence, and use the number as the root, naturally, the subsequence 1…(i-1) on its left side would lay on the left branch of the root, and similarly the right subsequence (i+1)…n lay on the right branch of the root. We then can construct the subtree from the subsequence recursively. Through the above approach, we could ensure that the BST that we construct are all unique, since they have unique roots.
    //
    //The problem is to calculate the number of unique BST. To do so, we need to define two functions:
    //
    //G(n): the number of unique BST for a sequence of length n.
    //
    //F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
    //
    //As one can see, G(n) is the actual function we need to calculate in order to solve the problem. And G(n) can be derived from F(i, n), which at the end, would recursively refer to G(n).
    //
    //First of all, given the above definitions, we can see that the total number of unique BST G(n), is the sum of BST F(i) using each number i as a root.
    //i.e.
    //
    //G(n) = F(1, n) + F(2, n) + ... + F(n, n).
    //Particularly, the bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).
    //i.e.
    //
    //G(0)=1, G(1)=1.
    //Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BST with the specified root F(i), is the cartesian product of the number of BST for its left and right subtrees. For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product). The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).
    //
    //i.e.
    //
    //F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    //Combining the above two formulas, we obtain the recursive formula for G(n). i.e.
    //
    //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    //In terms of calculation, we need to start with the lower number, since the value of G(n) depends on the values of G(0) … G(n-1).
    //
    //With the above explanation and formulas, here is the implementation in Java.

    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    // 1,1,2,3,5

    public static int num(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
           G[i] = G[i-2] + G[i-1];
        }

        return G[n];
    }

   // 540. Single Element in a Sorted Array (Medium)
   // Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
   // Output: 2
    //如果第四位和第五位相等，则向后找，因为前面都是一对对相等的
    //如果不相等，则向前找

    public int singleNonDuplicate(int[] nums) {

        int l=0, h=nums.length-1;
        while (l< h){
            int m = l + (h-l)/2;
            if (m % 2 == 1) {
             m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m+1]){  //数在右边，比如1，1，2(m)，2，3，4，4
                l = m+2;
            }else {
                h =m;
            }
        }
        return nums[l];
    }


    //寻找翻转数组的最小数
    public int findMin(int[] nums) {
        int l =0, h = nums.length-1;
        while (l < h){
            int m = l+(h-l)/2;
            if (nums[h] > nums[m]){
                h = m;
            }else {
                l = m+1;
            }
        }
        return nums[l];
    }

//    34. Search for a Range (Medium)
//
//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args){

       System.out.println(num(4));

    }


}
