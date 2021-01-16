package practice.DSA.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOne {
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

    public static void main(String[] args) {
        List<Integer> number = increment(new int[]{4,5,7,9,9});
        System.out.println(number);
    }
}
