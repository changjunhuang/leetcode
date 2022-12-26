package map;

/**
 * 547. 省份数量
 * TODO 未成功
 */
public class 省份数量 {


    public static void main(String[] args) {
        int[][] array = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};

        System.out.println(findCircleNum(array));
    }

    static int num = 0;

    public static int findCircleNum(int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            int zero = 0;
            for (int j = i + 1; j < isConnected[0].length; j++) {
                int temp = dfs(isConnected, i, j);
                if (temp == 1) {
                    num++;
                } else {
                    zero++;
                }
            }
            if (zero == isConnected[0].length - i + 1 || zero == 0) {
                num++;
            }
        }
        return num;
    }

    public static int dfs(int[][] isConnected, int i, int j) {
        if (isConnected[i][j] == 0) {
            return 0;
        }
        isConnected[i][j] = 0;
        if (i <= isConnected.length - 2 && j <= isConnected.length - 2) {
            for (int x = j; x < isConnected.length; x++) {
                for (int y = x + 1; y < isConnected[0].length; y++) {
                    if (isConnected[i][j] == 1) {
                        dfs(isConnected, x, y);
                    }
                }
            }
        }
        return 1;
    }


}
