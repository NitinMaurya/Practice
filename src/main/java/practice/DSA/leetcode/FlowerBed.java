package practice.DSA.leetcode;

public class FlowerBed {

    public boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                i = i + 1;
            } else if (
                    (i-1 >= 0 && arr[i-1] == 0 && i + 1 < len && arr[i+1] == 0)
                    || (i + 1 == len && i-1 >= 0 && arr[i-1] == 0)
                    || (i-1 < 0 && i + 1 < len && arr[i + 1] == 0)
                    || (i-1 < 0 && i + 1 == len && arr[i] == 0)
            ){
                arr[i] = 1;
                n--;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FlowerBed flowerBed = new FlowerBed();
        boolean result = flowerBed.canPlaceFlowers(
                new int[] {1,0,0,0,1},
                1
        );
        System.out.println(result);


    }
}
