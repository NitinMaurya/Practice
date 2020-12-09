package practice.DSA.practice;

public class ReachLast {
    private static boolean canReachLast(int[] array){
        int furthestReachIndex = 0;
        for(int i = 0; i <= furthestReachIndex && furthestReachIndex < array.length-1; i++) {
            furthestReachIndex = Math.max(furthestReachIndex, i + array[i]);
        }
        return furthestReachIndex >= array.length-1;
    }

    public static void main(String[] args) {
        System.out.println(canReachLast(new int[]{1,4,1,3,1,5,0,0,0}));
    }
}
