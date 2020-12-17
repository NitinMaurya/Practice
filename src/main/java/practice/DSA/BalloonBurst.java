package practice.DSA;

import java.util.LinkedList;
import java.util.List;

public class BalloonBurst {
    public int maxCoins(int[] nums) {
        int coins = 0;
        List<Integer> arr = new LinkedList<>();
        for (int num : nums) {
            arr.add(num);
        }

        while (!arr.isEmpty()) {
            int max = arr.size() == 1 ? Integer.MIN_VALUE : arr.get(1);
            int maxPos = 0;
            for (int i = 1; i < arr.size(); i++) {
                if ((i + 1 < arr.size() && arr.get(i-1) * arr.get(i + 1) > max) || (i  == arr.size() - 1 && arr.get(i-1) > max))           {
                    maxPos = i;
                    if (i == arr.size() - 1) {
                        max = arr.get(i-1);
                    } else {
                        max = arr.get(i-1) * arr.get(i+1);
                    }
                }
            }

            if (maxPos == 0 && arr.size() > 1) {
                coins = coins + (arr.get(maxPos) * arr.get(maxPos + 1));
            } else if (maxPos == 0) {
                coins = coins + (arr.get(maxPos));
            } else if (maxPos == arr.size() - 1) {
                coins = coins + (arr.get(maxPos - 1) * arr.get(maxPos));
            } else {
                coins = coins + (arr.get(maxPos - 1) * arr.get(maxPos) * arr.get(maxPos + 1));
            }
            arr.remove(maxPos);
        }

        return coins;
    }

    public static void main(String[] args) {
        System.out.println(new BalloonBurst().maxCoins(new int[] {
                9,76,64,21,97,60,5
        }));
    }
}
