package company.code.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort sorter = new QuickSort();
        sorter.quickSort(arr, 0, n-1);

        System.out.println("排序后的数组：");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_index = partition(arr, low, high);

            quickSort(arr, low, pivot_index-1);
            quickSort(arr, pivot_index+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        //基准点
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high; j++) {
            //如果比基准点小，则交换
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
