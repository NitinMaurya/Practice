package demo.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayProblems {
    public static void main(String[] args) {
//        int[] array = takeInput();
//        int[] array = new int[]{3,2,6,5,0,3};
//        int[] array = new int[]{0,9,9,9};
//        System.out.println(contiguousArray(array));
//        System.out.println(canReachLast(array));
//        printArray(myDeleteDuplicates(new int[]{2,3,5,5,7,11,11,11,13}));
//        System.out.println(deleteDuplicates(Arrays.asList(2,3,5,5,7,11,11,11,13)));
//        printArray(prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7));
//        printArray(rotate(new int[]{1,2,3,4,5,6,7}, 3));
        printArray(distributeCandies(10,3));

    }

    public static int[] distributeCandies(int c, int n) {
        int[] ans = new int[n];
        int i = 1;
        int tn = (n * (2 * n * i - n + 1))/2;
        while(c > tn){
            c = c % tn;
            i++;
            tn = (n * (2 * n * i - n + 1))/2;
        }
        for(int j = 0; j < n; j++){
            if (c <= 1){
                ans[j] = c;
            } else {
                ans[j] = ((j+1) + (i-1)*n) % c;
            }
            c = c - ((j+1) + (i-1)*n);
        }
        return ans;
    }

    private static void printArray(int[] array) {
//        System.out.println("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    private static int contiguousArray(int[] array) {
        /*  Find the maximum contiguous subArray with equal no of zeroes and ones in a binary array
        *
        *   5
        *   1 0 1 0 1
        *   4
        *
        * */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count = count + ((array[i] == 1) ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    private static List<Integer> increment(int[] array){
        List<Integer> num = new ArrayList<>();
        int n = array.length-1;
        int sum = array[n] + 1;
        int carry = sum / 10;
        num.add(sum % 10);
        for(int i = n-1; i >=0; i--){
            sum = array[i] + carry;
            num.add(sum%10);
            carry = sum/10;
        }
        if(carry > 0){
            num.add(carry);
        }
        Collections.reverse(num);
        return num;
    }

    private static boolean canReachLast(int[] array){
        int furthestReachIndex = 0;
        for(int i = 0; i <= furthestReachIndex && furthestReachIndex < array.length-1; i++) {
            furthestReachIndex = Math.max(furthestReachIndex, i + array[i]);
        }
        return furthestReachIndex >= array.length-1;
    }

    private static int[] myDeleteDuplicates(int[] array){
        int i = 0;
        int j = 1;
        while(i < array.length && j < array.length){
            if(array[i] == array[j]){
                j++;
                continue;
            } else if(j - i > 1){
                swap(array,i+1, j);
            }
            i++;
            j++;
        }
        i++;
        if(i < array.length){
            while (i < array.length){
                array[i] = 0;
                i++;
            }
        }
        return array;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int oldState;
        int temp;
        while(N-- > 0){
            oldState = cells[0];
            for(int i = 0; i < cells.length; i++){
                if(i == 0 || i == cells.length -1){
                    cells[i] = 0;
                } else {
                    temp = cells[i];
                    cells[i] = (oldState ^ cells[i+1]) == 0 ? 1 : 0;
                    oldState = temp;
                }
            }
//            System.out.print("Day " + N + ": ");
//            printArray(cells);
        }
//        System.out.println("--------------");
        return cells;
    }

    public static int[] rotate(int[] nums, int k) {
        int temp; int temp2;
        int i;
        int len = nums.length;
        for(int l = 0; l <= len/k; l++){
            temp = nums[l];
            i = l;
            while(true){
                if(i + k >= len){
                    break;
                }
                temp2 = nums[(i + k) % len];
                nums[(i + k) % len] = temp;
                temp = temp2;
                i = i + k;
            }
            nums[(i + k) % len] = temp;
        }
        return nums;
    }

    public static List<Integer> deleteDuplicates(List<Integer> A) {
        int writeIndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            System.out.println(A);
            if (!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex, A.get(i));
                writeIndex++;
            }
        }
        return A;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int[] takeInput() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

}
