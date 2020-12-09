package practice.DSA;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int count = 1;
        int i, j , k , l;
        for (int level = 0; level < Math.ceil(n/2.0); level++) {
            // upper
            for (j = level; j < n - level; j++) {
                mat[level][j] = count;
                count++;
            }

            // right
            for (i = level + 1; i < n - level; i++) {
                mat[i][n - 1 - level] = count;
                count++;
            }

            // bottom
            for (k = n - 2 - level; k >= level; k--)  {
                mat[n - 1 - level][k] = count;
                count++;
            }

            // left
            for (l = n - 2 - level; l >= level + 1; l--) {
                mat[l][level] = count;
                count++;
            }
            ArrayUtils.print(mat);
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = generateMatrix(3);
        System.out.println(":: FINAL ::");
        ArrayUtils.print(mat);
    }
}
