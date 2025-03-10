package arraylist.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 695. 岛屿的最大面积
 *
 * @author huangchangjun
 * @date
 */
public class 岛屿的最大面积 {
    private List<Map<Integer,Integer>> result = new ArrayList<>();

    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //  j列 i行
                    temp = findNeighbor(grid, j, i);
                    area = Math.max(area, temp);
                }
            }
        }
        return area;
    }

    //  x列 y行
    public int findNeighbor(int[][] map, int x, int y) {
        int sum = 1;
        if (map[y][x] == 0) {
            return 0;
        } else {
            map[y][x] = 0;
        }
        //  对应行小于等倒数第二层时，可以进行下探
        if (y <= map.length - 2) {
            sum += findNeighbor(map, x, y + 1);
        }
        //  对应列小于等倒数第二列时，可以进行右探
        if (x <= map[0].length - 2) {
            sum += findNeighbor(map, x + 1, y);
        }
        //  对应列大于等第二列时，可以进行左探
        if (x >= 1) {
            sum += findNeighbor(map, x - 1, y);
        }
        //  对应列大于等第二行时，可以进行上探
        if (y >= 1) {
            sum += findNeighbor(map, x, y - 1);
        }
        return sum;
    }


    //dfs 深度优先收索
    public int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {      //遍历二维数组
            for (int j = 0; j < grid[i].length; j++) {       //判断当前元素值是否是1
                if (grid[i][j] == 1) {
                    int num = depthSearch(grid, i, j);
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    public int depthSearch(int[][] grid, int i, int j) {     //深度优先搜索
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {     //条件 控制边界
            grid[i][j] = 0;
            // 当前数组数量加上 上下左右的大小， 得出该地域的大小总和
            int num = 1 + depthSearch(grid, i + 1, j) + depthSearch(grid, i - 1, j)
                    + depthSearch(grid, i, j + 1) + depthSearch(grid, i, j - 1);
            return num;
        }
        return 0;
    }

}
