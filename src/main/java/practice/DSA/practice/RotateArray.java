package practice.DSA.practice;


// Wrong
public class RotateArray {
    public static int[] rotate(int[] nums, int k) throws InterruptedException {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            ArrayUtils.swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayUtils.print(rotate(new int[]{1,2,3,4,5,6}, 6));
    }
}
