package company.code.search;

public class BinarySearch {

    public static void main(String[] args){

        int [] a = {1,2,4,5,8,9};

        int index1 = binarySearch1(a,9);
        System.out.println(index1);

        System.out.println(searchBinary(a,8,0,5));
    }


    public static int binarySearch1(int[] a ,int b){
        int mid = a.length/2;
        if (a[mid] == b){
            return mid;
        }

        int start = 0;
        int end  = a.length-1;
        while (start <= end){
             mid = (start + end)/2;
            if (b < a[mid]) {
                end=mid-1;
            }
            if (b > a[mid]){
                start = mid+1;
            }
            if (a[mid] == b){
                return mid;
            }
        }

        return -1;


    }


    public static boolean searchBinary(int[] matrix,int target ,int start,int end){

        if(start<=end) {
            System.out.println(end);

            int mid = (start + end) / 2;
            if (matrix[mid] == target) {
                return true;
            }
            System.out.println(matrix[mid]);
            if (matrix[mid] > target) {
                return searchBinary(matrix, target, 0, mid - 1);
            }
            if (matrix[mid] < target) {
                return searchBinary(matrix, target, mid + 1, end);
            }

        }
        return false;
    }

}
