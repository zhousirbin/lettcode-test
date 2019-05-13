package company.code.me;

import company.BinaryTree.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Coding {



    public static void main(String[] args){

        generate(3);
        System.out.println(getRow(3).toString());

        List<Integer> integers = Arrays.asList(1,2,3);
        List<Integer> integers1 = Arrays.asList(4,5,6);
        List<Integer> integers2 = Arrays.asList(7,5,8);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integers);
        lists.add(integers1);
        lists.add(integers2);
        System.out.println(minimumTotal(lists));

        System.out.println(maxProfit(new int[]{1,2,3,5,5,7,6}));

        System.out.println(maxProfit2(new int[]{3,3,5,0,0,3,1,4}));

        System.out.println(singleNumber(new int[]{1,1,2,2,3}));

        System.out.println(minCut("aabccd"));

        wordBreak("mycat",Arrays.asList("my", "cat"));

        System.out.println(singleNumber1(new int[]{2,2,2,1,4,4,4}));

        longPrefix(Arrays.asList("firs","fir","first"));
        String a = null;
        System.out.println(StringUtils.isBlank(a));


        longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});



       Coding coding = new Coding();
       List<List<String>> listList = coding.partition("aab");

       int[] w = new int[]{1,0,2};

       coding.candy(new int[]{1,0,2});

       int num = coding.minNumberRorateArray(new int[]{3,4,5,1,2});

       System.out.println(coding.numberOfOne(3));


        ListNode head = new ListNode(1);
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);


        head.next =node;
        node.next = node1;
        node1.next =node2;
        node2.next = node3;
        ListNode listNode = coding.lastKNode(head, 1);
        System.out.println(listNode.val);

        coding.isPopOrder(new int[]{1,2,3,4,5},new int[]{5,4,3,2,1});

        coding.findGreatestSumOfSubArray(new int[]{5,4,-2,-3,1,-4,4,-1});

        coding.firstNotRepeatingChar("abcbde");

        int count = coding.findPaiXuCiShu(new int[]{1,2,3,3,3,3,4,5}, 3);

        coding.findNumsAppearOnce(new int[]{1,1,2,3,3,5}, new int[1], new int[1]);

        boolean shun = coding.isShun(new int[]{1,2,3,6,0});
        coding.sum(5);

        coding.twoSum1(new int[]{1,2,3,4,5} ,5);


    }


    //115. Distinct Subsequences

    //Input: S = "rabbbit", T = "rabbit"
    //Output: 3
    //Explanation:
    //
    //As shown below, there are 3 ways you can generate "rabbit" from S.
    //(The caret symbol ^ means the chosen letters)
    //
    //rabbbit
    //^^^^ ^^
    //rabbbit
    //^^ ^^^^
    //rabbbit
    //^^^ ^^^
    public int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    //128. Longest Consecutive Sequence
    //Input: [100, 4, 200, 1, 3, 2]
    //Output: 4
    //Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    public int numDistinct1(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }



    //118，1；11；121；1331；
    //首先i=0时，加一,row(1);i=1时，前面插入一个1,row(1,1);i=2,前面插入一个1，--（1，1(a)，1(b)），循环变为（1，2(a+b)，1）;
    //i=3,第四行，，前面插入一个1，（1，1（a），2(b)，1(c)），循环变为（1，3(a+b)，3(b+c)，1）
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


    //119,返回第几行的值，比如row=3，返回121
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<rowIndex;i++){

            list.add(0,1);

            for(int j=1;j<list.size()-1;j++){
                list.set(j,list.get(j)+list.get(j+1));
            }


        }

        return list;
    }


    //120，找到每个list最小值相加
    public static int minimumTotal(List<List<Integer>> triangle) {

        int sum =0;
        for (List<Integer> list: triangle) {

            int min = list.get(0);
            for (int i=1;i<list.size()-1;i++){

                if (list.get(i) < min){

                    min = list.get(i);

                }
              System.out.println(min);
            }

            sum = sum + min;
        }
        return sum;
    }

    //121,best buy and
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
   // Not 7-1 = 6, as selling price needs to be larger than buying price.
    public static int maxProfit(int[] prices) {

        int min=prices[0],max=prices[0];
        for (int i=1;i<prices.length;i++){

            if (prices[i] <min ){
                min = prices[i];
            }
            if (prices[i] >max ){
                max = prices[i];
            }
        }
        return max-min;

    }

    //122: Input: [7,1,5,3,6,4]
    //Output: 7
    //Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    // Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    public int maxProfit1(int[] prices) {

        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;

    }

    //123: 最多两次，Input: [3,3,5,0,0,3,1,4]
    //Output: 6
    //Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    //Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    public static int maxProfit2(int[] prices) {

        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int price:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+price);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-price);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+price);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -price);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.

    }


    //两个数的和，return index
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){

            if (map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){

                return new int[]{i, map.get(target-nums[i])};
            }

        }
        throw new IllegalArgumentException();
    }

    //125,忽略大小写
    //Input: "A man, a plan, a canal: Panama"
    //Output: true

    //Input: "race a car"
    //Output: false

    public boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    //128 Input: [100, 4, 200, 1, 3, 2]
    //Output: 4
    //Explanation: 最长连续 elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    public static int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    //Input: [1,2,3]
    //    1
    //   / \
    //  2   3
    //Output: 25
    //Explanation:
    //The root-to-leaf path 1->2 represents the number 12.
    //The root-to-leaf path 1->3 represents the number 13.
    //Therefore, sum = 12 + 13 = 25.
    public int sumNumbers(TreeNode root) {


        return 0;
    }

    public static int sum(TreeNode root, int index){

        if (root==null) return 0;
        if (root.right==null && root.left==null) return index*10+(int)root.data;

        return sum(root.left,index*10+(int)root.data)+sum(root.right,index*10+(int)root.data);

    }


    //131. Palindrome Partitioning
//    Input: "aab"
//    Output:
//            [
//            ["aa","b"],
//            ["a","a","b"]
//            ]

    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

    //131 Input: "aab"
    //Output: 1
    //Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

    public static int minCut(String s) {

        int count = 0;
        int len =s.length();
        for (int i=0;i<len-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                continue;
            }

            count++;
        }
        return count;
        
    }


    //135Input: [1,0,2]
    //Output: 5
    //Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression 等差公式
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }
    public int candy1(int[] ratings) {
        int res = 0, n = ratings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n ; i++) {
            nums[i] = 1;

        }

        for (int i = 0; i < n - 1; ++i) {
            if (ratings[i + 1] > ratings[i]) nums[i + 1] = nums[i] + 1;
        }
        for (int i = n - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i]) nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
        }
        for (int num : nums) res += num;
        return res;
    }

    // 136 -- 找到的单一的元素
    // Input: [2,2,1]
    // Output: 1
    public static int singleNumber(int[] nums) {

        int  w = nums[0];
        for (int i=1;i<nums.length;i++){

             w = w ^  nums[i];
            System.out.println(w);


        }
       return w;
    }

    //137  Given a non-empty array of integers,
    // every element appears three times except for one,
    // which appears exactly once. Find that single one.
    //Example 1:
    //
    //Input: [2,2,3,2]
    //Output: 3
    public static int singleNumber1(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int mu = 0;
        for (int num:nums) {

            if (hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else {
                hashMap.put(num,1);
            }

        }

        for (Integer key: hashMap.keySet()){

            if (hashMap.get(key)==1){
                mu = key;
            }
        }

        return mu;

//        int ones = 0, twos = 0;
//        for(int i = 0; i < A.length; i++){
//            ones = (ones ^ A[i]) & ~twos;
//            twos = (twos ^ A[i]) & ~ones;
//        }
//        return ones;
    }

    public static Object getKey(Map map, Object value){
        List<Object> keyList = new ArrayList<>();
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }


    //139. Word Break
    //Input: s = "leetcode", wordDict = ["leet", "code"]
    //Output: true
    //Explanation: Return true because "leetcode" can be segmented as "leet code".
    //Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    //Output: false

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){

                String s1 = s.substring(j, i);
                if(f[j] && wordDict.contains(s1)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }


    public static String longPrefix( List<String> wordDict) {

        String first = wordDict.get(0);
        int len = first.length();
        for (int i=1;i<wordDict.size();i++){

            if (!wordDict.get(i).startsWith(first)){
                first = first.substring(0,len--);

            }

        }
        return null;
    }

    //12345  34512  23451  45123  51234
    public int minNumberRorateArray(int[] a){

        if (a.length==0) return 0;


        int start = 0,end = a.length-1;

        if (a[0]< a[end]){
            return a[0];
        }

        while (start<end){

            int mid = (start+end)/2;
            if (a[end]>a[mid]){
                end =mid;  //45123  51234  ,end大于mid,说明肯定是递增的，所以一定在mid前面，start,mid
            }else if (a[mid]>a[start]){
                start =mid;  // 34512  23451 ,mid大于start ,说明mid前面的已经被翻转到，后面了，所以为mid,end

            }else {
                end--; //2,2,2,2,1,2, 这种一定在后面
            }

        }
        return a[end];
    }


    //12345  34512  23451  45123  51234
    public int Fibonacci(int n) {
        if (n==0){
           return 0;
        }
        if (n==1){
            return 1;
        }
        int a =0, b=1;
        int i=2;
        int sum =0;
        while (i<=n){
            sum = a+b;
            a = b;
            b= sum;
            i++;
        }
       return sum;
    }

    public int numberOfOne(int n){
        if (n==0){
            return 0;
        }
        int count=1;
        while ((n&(n-1)) !=0 ){

            count++;
            n= n&(n-1);
        }
        return count;

    }

    // 1 3 4 5 6,倒数第三个，第一个指针 14325
    public ListNode lastKNode(ListNode listNode, int k){

        ListNode node   = listNode;
        ListNode first  = listNode;
        ListNode second = listNode;

        for (int i=0;i<k-1;i++){ //走k-1步，因为两个指针中间隔了k-1个。
            first = first.next;
        }

        while (first.next!= null){ //到最后一个
            first  = first.next;
            second = second.next;
        }

        return second;

    }

    public static boolean wordBreak1(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length()+1];

        f[0]  = true;
        for (int i=0;i<s.length();i++){
            for (int j=0;j<i;j++){
                if (f[j] && wordDict.contains(s.substring(j,i))){
                   f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];


    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
       int row = matrix.length;
       int col = matrix[0].length;

       ArrayList<Integer> arrayList = new ArrayList<>();


       int left =0, right = matrix[0].length-1, top = 0, botom = matrix.length-1;

       int count = 0;
       while (count < row*col){

           for (int i=left; i<=right; i++){
               arrayList.add(matrix[top][i]);
               count++;
               if(count >= col*row)
                   return arrayList;
           }

           top++;

           for (int j = top;j<=botom; j++){
               arrayList.add(matrix[j][right]);
               count++;
               if (count>=col*row){
                   return arrayList;
               }

           }

           right--;

           for (int i=right; i>=left; i--){
               arrayList.add(matrix[top][i]);
               count++;
               if(count >= col*row)
                   return arrayList;
           }
           botom--;

           for (int  i=botom;i>=top;i--){
              arrayList.add(matrix[i][left]) ;
              count++;
               if(count >= col*row)
                   return arrayList;
           }

           left++;

       }
       return arrayList;


    }

    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length)
            return false;
        Stack<Integer> stack1 = new Stack<>();//栈记录压栈
        int j = 1;
        stack1.push(pushA[0]);//栈中先压入push压栈序列的第一个数
        for (int i = 0; i < popA.length; i++) {
            while (j < pushA.length && stack1.peek() != popA[i]) {//如果栈顶的数和弹出序列不一样，就一直压栈，因为必须是从栈顶弹出的！
                stack1.push(pushA[j]);
                j++;
            }
            if (j >= pushA.length && stack1.peek() != popA[i])
                return false;//如果j已经到达压栈序列的末尾，但是栈顶的数还是和弹出序列当前的数不一致
            //说明没有这个序列
            stack1.pop();
        }
        return true;
    }

    //找到所有和等于一个数，所有路径
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        ArrayList<Integer> list = new ArrayList<>();
        FindPath(root,target,0,list);
        return resultList;
    }
    public void FindPath(TreeNode root,int target,int sum,ArrayList<Integer> list)
    {
        if(root == null)
            return;
        sum += (int)root.data; //sum不是引用，所以sum在每一层的递归中都是不同的值，记录当前的节点和
        list.add((int)root.data);
        if(sum == target && root.left == null && root.right == null)
        {//找到这样的路径了~
            resultList.add(new ArrayList<Integer>(list));//存入结果数组
            list.remove(list.size()-1);//找到以后还要接着找啊，所以先把当前最后的叶子节点删除
            return;
        }
        FindPath(root.left,target,sum,list);//左右子树递归进去去找
        FindPath(root.right,target,sum,list);
        list.remove(list.size()-1);//这里左右子树都找完了，回到了找完的左右子树的父节点
        //由于父节点的左右子树找完了，所以父节点这里也没有用了，把父节点删除
    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        BuildArrayList(pRootOfTree,nodeList);//这个函数执行后，数组中每个元素按照大小前后排序
        for(int i=0;i<nodeList.size();i++)
        {
            if(i == 0)
            {//数组的第一个节点处理，只有右子树指向下一个节点
                nodeList.get(0).right = nodeList.get(1);
            }
            else if(i == nodeList.size()-1)
            {//数组的最后一个节点，只有左子树指向前一个节点
                nodeList.get(i).left = nodeList.get(i-1);
            }
            else{//数组中的中间节点，左子树指向上一个节点，右子树指向数组的下一个节点
                nodeList.get(i).left = nodeList.get(i-1);
                nodeList.get(i).right = nodeList.get(i+1);
            }
        }
        return nodeList.get(0);
    }
    public void BuildArrayList(TreeNode root,ArrayList<TreeNode> nodeList)
    {//二叉搜索的中序遍历，并把每个节点存入数组中
        if(root == null)
            return;
        if(root.left != null)//左子树
            BuildArrayList(root.left,nodeList);
        if(root != null)//根节点
            nodeList.add(root);
        if(root.right != null)//右子树
            BuildArrayList(root.right,nodeList);
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0)
            return 0;
        int count = 1;
        int number = array[0];
        for(int i=1;i<array.length;i++)
        {
            if(array[i] == number)
            {//如果与number相等，那么count++，可能是超过一半的那个数
                count++;
            }else{
                count--;//如果与number不相等，count就减一
                if(count == 0)
                {//如果count等于0了，说明这个数在这里出现次数已经被抵消了
                    count = 1;//重新记录count为1
                    number = array[i];//number记录当前这个数
                }
            }
        }
        if(count > 0)
        {//如果count大于0说明有可能存在这样的数，是出现次数大于数组的一半的
            //还有一种可能是最后刚好一个数连续出现了2次，导致count>0
            count = 0;
            for(int i=0;i<array.length;i++)
            {//去遍历数组，计数这个number到底出现了几次
                if(number == array[i])
                    count++;
            }
            if(count > array.length/2)
                return number;//出现超过一半
        }
        return 0;
    }

    //k个最小的数
    public ArrayList<Integer> getLeastNumbersSolution(int [] input, int k) {

        int len = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i=0;i<len;i++){
            if (i<k){
                priorityQueue.add(input[i]);
            }else {
                if (input[i]<priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(input[i]);
                }
            }

        }
        while (!priorityQueue.isEmpty()){
            list.add(priorityQueue.poll());
        }
        return list;
    }

    //连续子数组的最大和
    public int findGreatestSumOfSubArray(int[] array) {
        int curMax = 0;
        int realMax = array[0];
        for (int num:array){
            if (curMax>=0){
                curMax = curMax+num;
            }else {
                curMax = num;
            }
            if (curMax > realMax){
                realMax = curMax;
            }
        }
        return realMax;
    }

    //找到第一个不重复的字符串，主要通过定一个数组，将各个字符放进去，并记录index,哪个字符出现index++,遍历整个数组，找到最小的index.
    public int firstNotRepeatingChar(String str) {
        if(str.equals(""))
            return -1;
        int [] temp = new int[256];
        int index = 1;
        char [] strArray = str.toCharArray();
        for(int i=0;i<strArray.length;i++)
        {
            if(temp[(int)strArray[i]] == 0)
            {
                temp[(int)strArray[i]] = index;
                index++;   //会记录所有的出现一次的index,比如a,d,c,a,f,index为1，2，3， ，4
            }else{
                temp[(int)strArray[i]] = -1;
            }
        }//这个循环就是遍历一遍，找到出现一次的字符
        //只要index大于0就是出现一次的字符
        int minIndex = Integer.MAX_VALUE;
        char ch = '1';
        for(int i=0;i<temp.length;i++)
        {
            if(temp[i] > 0)
            {
                if(temp[i] < minIndex)  //遍历所有的temp，找到最小的index.
                {//找最小的index对应的字符
                    minIndex = temp[i];
                    ch = (char)i;
                }
            }
        }
        int result = -1;
        for(int i=0;i<strArray.length;i++)
        {//去找这个字符的下标！
            if(strArray[i] == ch)
                return i;
        }
        return -1;
    }

    public int findPaiXuCiShu(int[] a, int target) {
        int index = binarySearch(a,0, a.length, target);
        int start  =index;
        int end    =index;
        int count  =1;
        while (--start >= 0 ){
            if(a[start] ==target){
                count++;
            }
        }
        while (++end <a.length-1){
            if( a[end] ==target){
                count++;
            }
        }
        return count;
    }

    public int binarySearch(int[] a, int start, int end, int target){
        if (start < end){
            int mid = (start + end)/2;
            if (a[mid] == target){
                return mid;
            }
            if (a[mid]< target){
                binarySearch(a, mid+1,end, target);
            }
            if (a[mid] > target){
                binarySearch(a, start, mid-1, target);
            }
        }
        return -1;
    }

    public int findDepth(TreeNode<Integer> root){

        if (root ==null){
            return 0;
        }
        if (root != null&& root.right==null && root.left==null){
            return 1;
        }

        return findDepth(root.left) > findDepth(root.right) ? findDepth(root.left)+1 :findDepth(root.right)+1;

    }


    boolean flag = true;
    public boolean isBalanceTree(TreeNode<Integer> root){

        treeLength(root);
        return flag;

    }

    public int treeLength(TreeNode<Integer> root){

        if (root == null){
            return 0;
        }

        int left  = treeLength(root.left);
        int right = treeLength(root.right);

        if (left-right >= 2 || right-left >=2){

            flag = false;
        }

        return left > right? left+1:right+1;

    }

    //找到数组中，两个不同的数
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        for(int i=0;i<array.length;i++)
        {
            temp = temp ^ array[i];//异或，相同为0，不同为1,101 010
        }
        int index = findOne(temp);//找到第一个不为0的位置，这个就是不同点
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<array.length;i++)
        {
            if(IsBit1(array[i],index))//根据这个不同的位置进行区分。
            {
                num1[0] ^= array[i];//分成两组，每一组再分别异或，相同的都成0了，剩下了那唯一一个不同的
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    //找到第一个不为0的位置
    private int findOne(int number)
    {
        int index = 0;
        while((number & 1) == 0)
        {
            index++;
            number = number >> 1;
        }
        return index;
    }

    private boolean IsBit1(int number,int index)
    {
        number = number >> index;
        if((number & 1) == 0)
            return false;
        return true;
    }

    //是否是顺
    public boolean isShun(int[] nums){

        int zeroCount = 0;
        int numNeed   = 0;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0){
                zeroCount++;
            }else{
                if (i < nums.length-1){
                    numNeed += nums[i+1] - nums[i] -1;
                }
            }
        }
        if (zeroCount >=numNeed){
            return true;
        }
        return false;
    }

    //1+2+3....+n
    int temp =0 ;
    public int sum(int n){
       return complex(n);
    }

    public int complex(int n){
        boolean flag = (n-1)>0 && (temp =temp+n)>0 && complex(n-1) >=0;
        return temp;
    }


    //不用+号进行计算
    //主要通过两步，第一步：两个数异或，第二步，两个数&，如果不为0，左移一位，  继续和当做a,异或的值当做b.
    public int add(int a,int b){

        int sum   = 0;
        int carry = 0;
        do {
             sum = a^b;
             carry = a&b;
            if (carry !=0){
                carry = carry << 1;
            }
            a = sum;
            b = carry;
        }while (carry !=0); //当carry为0时退出循环


        return sum;
    }


    //矩阵数组  给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
   //https://blog.csdn.net/qq_28081081/article/details/80875917
    public int[] multiply(int[] a) {

        int[] b = new int[a.length];
        b[0] = 1;
        for (int i=0; i<a.length; i++){
            b[i] = b[i-1] * a[i-1];
        }

        int temp = 1;
        for (int j=a.length-2;j>=0;j--){

            temp = temp * a[j+1];
            b[j] = b[j] *temp;
        }

        return b;
    }

    //https://blog.csdn.net/ljh0302/article/details/80811244
    //首先证明如果相遇，那么慢的节点一定走了r=x,由
    //slow设置为走了x个节点，kuai则走了2*x的节点，如果slow第一圈相遇,快的等于慢的+一圈：x+r=2x;则x=r。 那么slow到相遇点处的长度，正好等于起始点到相遇点的长度。所以相遇的时候，快的刚好比慢的多跑了一圈。
    //找到环的节点
    public ListNode EntryNodeOfLoop2(ListNode pHead){

         ListNode fast = pHead;
         ListNode slow = pHead;

         while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
             //当快指针 与 慢指针相遇时
             if(fast == slow){
                 fast = pHead;
                 //再次相遇
                 while(fast != slow){
                        fast = fast.next;
                         slow = slow.next;
                     }
                 return fast;
             }
         }
         return null;
    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                fast = pHead;
                while (fast != slow) {

                    fast = fast.next;
                    slow = slow.next;

                }
                return fast;

            }
        }
        return null;
    }

    //题目描述：在有序数组中找出两个数，使它们的和为 target。
    public int[] twoSum1(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;
        while (start< end){
            if (numbers[start] + numbers[end] == target){
                return new int[]{numbers[start], numbers[end]};
            }
            if (numbers[start] + numbers[end] > target){
                end--;
            }
            if (numbers[start] + numbers[end] > target){
                start++;
            }

        }

        return null;

    }

    //翻转字符串的元音字母
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {

        int start    = 0;
        int end      = s.length()-1;
        char[] chars = new char[s.length()];

        while (start <= end){
            char ci = s.charAt(start);
            char cj = s.charAt(end);
            if (!vowels.contains(ci)){

                chars[start++] = ci;

            }else if (!vowels.contains(cj)){
                chars[end--] = cj;
            }
            else {
                chars[start++] = cj;
                chars[end--]   = ci;
            }


        }



        return String.valueOf(chars);

    }


    //680. Valid Palindrome II (Easy)
    //
    //Input: "abca"
    //Output: True
    //Explanation: You could delete the character 'c'.
    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome1(s, i, j - 1) || isPalindrome1(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome1(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    //88. Merge Sorted Array (Easy)
    //
    //Input:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //Output: [1,2,2,3,5,6]
    //题目描述：把归并结果存到第一个数组上。
    //
    //需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
    public void merge(int[] nums1, int m, int[] nums2, int n) {



    }


    //524. Longest Word in Dictionary through Deleting (Medium)
    //
    //Input:
    //s = "abpcplea", d = ["ale","apple","monkey","plea"]
    //
    //Output:
    //"apple"
    //题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。

    public String findLongestWord(String s, List<String> d) {

        return null;

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key); //设置多个桶，每个桶放入频率相同的元素。比如4个7，4个2，则放入7和2.
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) { //如果当前桶的个数，小于等于k-列表的元素个数，则直接添加这个桶
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size())); //否则，添加这个桶的部分元素
            }
        }
        return topK;
    }

}
