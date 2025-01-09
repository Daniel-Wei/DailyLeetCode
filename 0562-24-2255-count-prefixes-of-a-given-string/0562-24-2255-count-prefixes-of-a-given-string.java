class Solution {
    public int countPrefixes(String[] words, String s) {
        Trie trie = new Trie();
        trie.insert(s);
        int res = 0;

        for(String w : words){
            if(trie.findPrefixCount(w)){
                res++;
            }
        }

        return res;

    }

    public class Trie {
        Node root = new Node();

        public void insert(String word){
            Node curr = root;

            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';

                if(curr.nodes[index] != null){
                    curr = curr.nodes[index];
                }else{
                    curr.nodes[index] = new Node();
                    curr = curr.nodes[index];
                }
            }
        }

        public boolean findPrefixCount(String prefix) {
            Node curr = root;
            int p = prefix.length();

            for(int i = 0; i < p; i++){
                int index = prefix.charAt(i) - 'a';

                if(curr.nodes[index] == null){
                    break;
                }else{
                    curr = curr.nodes[index];

                    if(i == p - 1){
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public class Node {
        Node[] nodes = new Node[26];
    }
}