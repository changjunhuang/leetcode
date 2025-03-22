package arraylist.mid;

/**
 * 74. 搜索二维矩阵
 *
 * @author huangchangjun
 * @date 2025-03-22
 */
public class 搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            int temp = matrix[i][j] > target ? j-- : i++;
        }
        return false;
    }
}
