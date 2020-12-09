package practice.DSA.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            q.offer(stone);
        }
        while(q.size() > 1){
            System.out.println(q);
            int x = q.poll();
            int y = q.poll();
            if(x != y){
                q.offer(x - y);
            }
        }
        if (q.isEmpty()){
            System.out.println(0);
        }
        System.out.println(q.poll());
    }
}
