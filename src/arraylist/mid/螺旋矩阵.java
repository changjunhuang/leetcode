package arraylist.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @author huangchangjun
 * @date 2025-03-14
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        dfs(matrix, 0, 0, result);
        return result;
    }

    public static void dfs (int[][] matrix, int i, int j, List<Integer> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1000) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = -1000;
        // 向右遍历
        dfsRight(matrix, i, j + 1, result);
        // 向下遍历
        dfsDown(matrix, i + 1, j, result);
        // 向左遍历
        dfsLeft(matrix, i, j - 1, result);
        // 向上遍历
        dfsUp(matrix, i - 1, j, result);
    }

    public static void dfsRight (int[][] matrix, int i, int j, List<Integer> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1000) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = -1000;
        // 向右遍历
        dfsRight(matrix, i, j + 1, result);
        // 向下遍历
        dfsDown(matrix, i + 1, j, result);
        // 向左遍历
        dfsLeft(matrix, i, j - 1, result);
        // 向上遍历
        dfsUp(matrix, i - 1, j, result);
    }

    public static void dfsDown (int[][] matrix, int i, int j, List<Integer> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1000) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = -1000;
        // 向下遍历
        dfsDown(matrix, i + 1, j, result);
        // 向左遍历
        dfsLeft(matrix, i, j - 1, result);
        // 向上遍历
        dfsUp(matrix, i - 1, j, result);
        // 向右遍历
        dfsRight(matrix, i, j + 1, result);
    }

    public static void dfsLeft (int[][] matrix, int i, int j, List<Integer> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1000) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = -1000;
        // 向左遍历
        dfsLeft(matrix, i, j - 1, result);
        // 向上遍历
        dfsUp(matrix, i - 1, j, result);
        // 向右遍历
        dfsRight(matrix, i, j + 1, result);
        // 向下遍历
        dfsDown(matrix, i + 1, j, result);
    }

    public static void dfsUp (int[][] matrix, int i, int j, List<Integer> result) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1000) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = -1000;
        // 向上遍历
        dfsUp(matrix, i - 1, j, result);
        // 向右遍历
        dfsRight(matrix, i, j + 1, result);
        // 向下遍历
        dfsDown(matrix, i + 1, j, result);
        // 向左遍历
        dfsLeft(matrix, i, j - 1, result);
    }

}
