package practice.DSA;

import java.util.Scanner;

public class BuyAndSellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputString = scanner.nextLine().replaceAll(" ", "").split(",");
        int min = Integer.parseInt(inputString[0]);
        int maxProfit = 0;
        int price;
        for (int i = 1; i < inputString.length; i++) {
            price = Integer.parseInt(inputString[i]);
            if(price < min){
                min = price;
            }
            if(price - min > maxProfit){
                maxProfit = price - min;
            }
        }
        System.out.println(maxProfit);
    }
}
