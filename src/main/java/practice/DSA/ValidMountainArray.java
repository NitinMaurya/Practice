package practice.DSA;

public class ValidMountainArray {
    public static boolean isValidMountain(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;

        // for increasing array
        while (i+1 < arr.length && arr[i] < arr[i+1]) {
            i++;
        }
        if (i == 0 || i == arr.length - 1){
            return false;
        }

        // for decreasing array
        while (i+1 < arr.length && arr[i] > arr[i+1]) {
            i++;
        }
        return i == arr.length-1;
    }

    public static void main(String[] args) {
        int[] validInput = new int[] {1,3,4,5,3,1};
        int[] invalidInput = new int[] {1,3,3,4,5,3,1};
        System.out.println(isValidMountain(validInput));
        System.out.println(isValidMountain(invalidInput));
    }
}
