package practice.DSA.leetcode;


public class RotateMatrix {
    public void rotate(int[][] matrix) {
        ArrayUtils.print(matrix);
        int len = matrix.length, temp, temp1;
        for (int i = 0; i < len / 2; i++) {

            for (int j = i; j < len - (i + 1); j++) {

                temp = matrix[i+j - i][len-1-i];
                matrix[i+j - i][len-1-i] = matrix[i][j];

                temp1 = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = temp;

                temp = matrix[len-1-j][i];
                matrix[len-1-j][i] = temp1;

                matrix[i][j] = temp;

//                ArrayUtils.print(matrix);
            }
        }
    }

    public static void main(String[] args) {
        new RotateMatrix().rotate(
                new int [][] {
                        {5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}
                }
        );
    }
}
