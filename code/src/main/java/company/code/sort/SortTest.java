package company.code.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("zhou");
        list.add("zhan");
        list.add("yong");

        Collections.sort(list);


        System.out.println(list);

        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
       int[] a = sort(arrays,0,10);
       System.out.println(a[0]);
        System.out.println(sort1(arrays,0,10)[10]);
    }

    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }
/*
*首先两个比较，比较完是哪个比较，三个比较完，合并两个三个的，合并为6个。
 */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public  static  int[] sort1(int[] a ,int low,int high){
        int mid = (low+high)/2;
        if (low < high){
            sort1(a, low, mid);
            sort1(a, mid+1,high);
            merge1(a,low ,mid,high);

        }
        return a;
    }

    public static void merge1(int[] a ,int low, int mid , int high){
        int[] temp  = new int[high-low+1];
        int i=low;
        int k=0;
        int j=mid+1;
        while (i<mid && j< high){
            if (a[i]<a[j]){
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid){
            temp[k++] = a[i++];
        }

        while (j<= high){
            temp[k++] = a[j++];
        }

        for (int x=0 ;x<temp.length ; x++){
            a[x+low] = temp[x];
        }

    }
}
