package company.annotion;

public class TestO1 {

    public static void main(String[] args){


       int [] a = {1,2,4,5,8,9,7,3};

        System.out.println(findX(a,3,5));


    }

    public static int findX(int [] array, int x, int maxIndex){

        int indexPre  = binarySearch(array,0,maxIndex,x);
        int start = maxIndex+1 ,end = array.length-1;
        while (start<=end){
            int temp       = array[end];
            array[end]     = array[start];
            array[start]   = temp;
            start++;
            end--;
        }
        int indexLast = binarySearch(array,maxIndex+1,array.length-1,x);

        if (indexPre != -1){
            return indexPre;
        }

        if (indexLast != -1){
            return end+maxIndex+1-indexLast+1;
        }
        return -1;

    }

    public static int binarySearch(int[] a ,int low,int high,int b){
        if(low<=high) {
            int mid = (low + high) / 2;
            if (b == a[mid]) {
                return mid;
            }
            if (b < a[mid]) {
                return binarySearch(a, low, mid-1, b);
            }
            if (b > a[mid]) {
                return binarySearch(a, mid+1, high, b);
            }
        }

        return -1;
    }
}
