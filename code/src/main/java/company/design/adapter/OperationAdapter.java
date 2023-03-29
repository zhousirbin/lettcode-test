package company.design.adapter;

/**
 * 适配者，通过sort接口去适配quickSort
 * 需要原始接口ScoreOperation
 * 适配者：继承或者实现原始接口，需要注入需要被适配的接口或者类
 */
class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj; //定义适配者QuickSort对象
    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int array[]) {
        return sortObj.quickSort(array); //调用适配者类QuickSort的排序方法
    }

    public int search(int array[],int key) {
        return searchObj.binarySearch(array,key); //调用适配者类BinarySearch的查找方法
    }
}
