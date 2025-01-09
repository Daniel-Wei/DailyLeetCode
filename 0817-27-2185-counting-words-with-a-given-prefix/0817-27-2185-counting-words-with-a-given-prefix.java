class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        return trie.findPrefixCount(pref);
    }

    public class Trie {
        Node root = new Node();

        public void insert(String word){
            Node curr = root;

            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';

                if(curr.nodes[index] != null){
                    curr = curr.nodes[index];
                    curr.count++;
                }else{
                    curr.nodes[index] = new Node();
                    curr = curr.nodes[index];
                }
            }
        }

        public int findPrefixCount(String prefix) {
            Node curr = root;
            int p = prefix.length();

            for(int i = 0; i < p; i++){
                int index = prefix.charAt(i) - 'a';

                if(curr.nodes[index] == null){
                    break;
                }else{
                    curr = curr.nodes[index];

                    if(i == p - 1){
                        return curr.count;
                    }
                }
            }

            return 0;
        }
    }

    public class Node {
        int count = 1;
        Node[] nodes = new Node[26];
    }
}