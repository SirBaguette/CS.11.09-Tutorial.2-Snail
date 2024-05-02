public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || !isPerfectSquare(array2d)) {
            return new int[0];
        }
        int y = array2d.length;
        int x = array2d[0].length;
        if (x != y) {
            return new int[0];
        }
        int[] result = new int[x * y];
        int index = 0;
        int top = 0;
        int bottom = y - 1;
        int left = 0;
        int right = x - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[index++] = array2d[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[index++] = array2d[i][right];
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = array2d[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = array2d[i][left];
                }
                left++;
            }
        }
        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */

    public static int[][] makeSnail(int[] array1d) {
        int length = array1d.length;
        int sideLength = (int) Math.sqrt(length);

        if (sideLength * sideLength != length) {
            return new int[0][0];
        }
        int[][] snail = new int[sideLength][sideLength];
        int[] flattenedSnail = flattenSnail(snail);
        if (flattenedSnail.length != length) {
            return new int[0][0];
        }
        int currentIndex = 0;

        for (int layer = 0; layer < sideLength / 2; layer++) {
            int last = sideLength - 1 - layer;

            for (int i = layer; i <= last; i++) {
                snail[layer][i] = array1d[currentIndex++];
            }

            for (int i = layer + 1; i <= last; i++) {
                snail[i][last] = array1d[currentIndex++];
            }

            for (int i = last - 1; i >= layer; i--) {
                snail[last][i] = array1d[currentIndex++];
            }

            for (int i = last - 1; i > layer; i--) {
                snail[i][layer] = array1d[currentIndex++];
            }
        }
        if (sideLength % 2 != 0) {
            int center = sideLength / 2;
            snail[center][center] = array1d[currentIndex];
        }
        return snail;
    }
    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int a = 0; a<array1d.length; a++){
            System.out.print(array1d[a] + " ");
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int a = 0; a<array2d.length; a++){
            for (int b = 0; b<array2d[0].length; b++){
                System.out.print(array2d[a][b] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        return Math.sqrt(array1d.length)%1 == 0;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        return array2d.length == array2d[0].length;
    }


}
