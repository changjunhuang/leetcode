package map.mid;

/**
 * @author huangchangjun
 * @date 2025-03-21
 */
public class 实现Trie前缀树 {


    class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        // 插入一个单词到Trie树中
        public void insert(String word) {
            // 获取根节点
            Trie node = this;
            // 遍历单词的每个字符
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                // 如果当前字符不存在，就初始化一个节点
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                // 继续遍历下一个节点
                node = node.children[index];
            }
            // 标记当前节点是一个单词的结尾
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}
