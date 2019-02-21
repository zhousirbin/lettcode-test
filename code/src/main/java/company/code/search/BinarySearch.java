package company.code.search;

public class BinarySearch {

    public static void main(String[] args){

        int [] a = {1,2,4,5,8,9};
        int index = binarySearch(a,0,5,8);

        System.out.println(index);
        int index1 = binarySearch1(a,9);
        System.out.println(index1);
    }

    public static int binarySearch(int[] a ,int low,int high,int b){
        int mid = (low + high)/2;
        if (b == a[mid]){
            return mid;
        }
        if (b< a[mid]){
            return binarySearch(a,low,mid,b);
        }
        if(b > a[mid]){
            return binarySearch(a,mid,high,b);
        }

        return -1;
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
}
