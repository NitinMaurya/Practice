package practice.DSA;

public class QuickSort {

    public void sort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    private void sort(int[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr, i , j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{2,5,3,7,9,1};
        quickSort.sort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.println(value);
        }
    }
}
