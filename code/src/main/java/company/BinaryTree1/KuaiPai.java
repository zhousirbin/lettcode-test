package company.BinaryTree1;

public class KuaiPai {
    public int getMiddle(Integer[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            //从后向前
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public int  getMiddle1(Integer[] list, int low,int high){

        int temp = list[low];
        while(low<high){
            if (low<=high && list[high]> temp){
                high--;
            }
            list[low] = list[high];
            if (low<=high && list[low]<temp){
                low++;
            }
            list[high] = list[low];


        }
        list[low] = temp;
        return low;
    }

    public void _quickSort(Integer[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

}
