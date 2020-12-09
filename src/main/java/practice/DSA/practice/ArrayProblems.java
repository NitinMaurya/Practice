package practice.DSA.practice;

public class ArrayProblems {
    public static void main(String[] args) {
        ArrayUtils.print(prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7));

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
        }
        return cells;
    }
}
