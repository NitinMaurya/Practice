package demo.algorithms.arrays;

public class DutchNationalFlag {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,2,0,1,1,2,0};
        sort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void sort(int[] arr) {
        int curr = 0;
        int last = arr.length-1;
        int i = -1;
        while(curr < last){
            if(arr[curr] == 0){
                i++;
                swap(arr, curr, i);
            } else if(arr[curr] == 2) {
                swap(arr, last , curr);
                last--;
            }
            curr++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
