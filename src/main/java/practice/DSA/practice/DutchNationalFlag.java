package practice.DSA.practice;

public class DutchNationalFlag {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,2,0,1,1,2,0};
        sort(arr);
        ArrayUtils.print(arr);
    }

    private static void sort(int[] arr) {
        int curr = 0;
        int last = arr.length-1;
        int i = -1;
        while(curr < last){
            if(arr[curr] == 0){
                i++;
                ArrayUtils.swap(arr, curr, i);
            } else if(arr[curr] == 2) {
                ArrayUtils.swap(arr, last , curr);
                last--;
            }
            curr++;
        }
    }
}
