package str;

public class 宝石和石头 {
    public int numJewelsInStones(String J, String S) {
        int[] array = new int[58];
        //映射进数组
        for (int i = 0; i < J.length(); i++) {
            int temp = J.charAt(i) - 65;
            array[temp] = 1;
        }
        //遍历字符串进行判断
        int result = 0;
        for (int j = 0; j < S.length(); j++) {
            int temp = S.charAt(j) - 65;
            if (array[temp] == 1) {
                result++;
            }
        }
        return result;
    }
}
