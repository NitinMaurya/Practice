package practice.DSA;

public class ArrivalDeparture {
    public static int maxPlatformRequired(int[] arrival, int[] departure) {
        int maxPlatform = 0;
        int[] platform = new int[14];
        for (int i = 0; i < arrival.length; i++) {
            platform[arrival[i]]++;
            platform[departure[i]+1]--;
        }
//        ArrayUtils.print(platform);
        for (int i = 1; i < 13; i++) {
            platform[i] = platform[i-1] + platform[i];
            maxPlatform = Math.max(maxPlatform, platform[i]);
        }
        ArrayUtils.print(platform);
        return maxPlatform;
    }

    public static void main(String[] args) {
        int[] arrival = new int[] {1,2,5,5,9};
        int[] departure = new int[] {4,5,9,12,12};
        System.out.println(maxPlatformRequired(arrival, departure));
    }
}
