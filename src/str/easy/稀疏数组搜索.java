package str.easy;

/**
 * 面试题 10.05. 稀疏数组搜索
 */
public class 稀疏数组搜索 {
    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if ("".equals(words[i]) || words[i] == null) {
                continue;
            }
            if (words[i].equals(s)) {
                return i + 1;
            }
        }
        return -1;
    }
}
