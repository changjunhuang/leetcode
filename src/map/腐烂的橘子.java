package map;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @author huangchangjun
 * @date 2025-03-20
 */
public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        // 存储当前需要查找周围的已腐烂橘子
        Queue<int[]> orangeToCheckQueue = new ArrayDeque<>();
        int totalMin = -1;
        boolean hasNoOrange = true;
        // 先遍历一遍看看有哪些橘子已经烂了, 顺便看看有没有可能根本没橘子
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    orangeToCheckQueue.offer(new int[]{i, j});
                    hasNoOrange = false;
                }
                if (grid[i][j] == 1) {
                    hasNoOrange = false;
                }
            }
        }
        // 如果确实没橘子，返回0
        if (hasNoOrange) {
            return 0;
        }

        // 统计当前时刻的所有烂橘子
        int currentSize = orangeToCheckQueue.size();
        // 当前时刻的所有烂橘子的周围都被更新完以后进入下一时刻
        int count = 0;
        while (!orangeToCheckQueue.isEmpty()) {
            int[] curPosition = orangeToCheckQueue.poll();
            changeOrangeState(orangeToCheckQueue, grid, curPosition[0],
                    curPosition[1]);
            count++;
            // 判断当前批次的烂橘子是否处理完
            if (count == currentSize) {
                // 初始下一批次烂橘子的数量
                currentSize = orangeToCheckQueue.size();
                count = 0;
                totalMin++;
            }
        }
        // 最后再遍历一遍，如果仍然有新鲜的橘子就返回-1；
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return totalMin;
    }

    private void changeOrangeState(Queue<int[]> orangeToCheckQueue, int[][] grid, int row, int col) {
        // 上下左右四个方向的橘子
        // 上
        if (row >= 1 && row < grid.length && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            orangeToCheckQueue.offer(new int[]{row - 1, col});
        }
        // 下
        if (row >= 0 && row < grid.length - 1 && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            orangeToCheckQueue.offer(new int[]{row + 1, col});
        }
        // 左
        if (col >= 1 && col < grid[0].length && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            orangeToCheckQueue.offer(new int[]{row, col - 1});
        }
        // 右
        if (col >= 0 && col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            orangeToCheckQueue.offer(new int[]{row, col + 1});
        }
    }
}
