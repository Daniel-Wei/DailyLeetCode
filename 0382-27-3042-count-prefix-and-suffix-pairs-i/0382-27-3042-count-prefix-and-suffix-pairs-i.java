class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        int n = words.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                int li = words[i].length();
                int lj = words[j].length();

                if(li > lj){
                    continue;
                }

                Trie prefixTrie = new Trie(words[j]);
                Trie suffixTrie = new Trie(new StringBuilder(words[j]).reverse().toString());

                if(prefixTrie.prefix(words[i]) && suffixTrie.prefix(new StringBuilder(words[i]).reverse().toString())){
                    res++;
                }
            }
        }

        return res;
    }


    class Trie {
        Node root = new Node();

        public Trie(String word) {
            insert(word);
        }
        
        public void insert(String word) {
            Node curr = root;
            int index = -1;

            for(int i = 0; i < word.length(); i++){
                index = word.charAt(i) - 'a';
                if(curr.nodes[index] != null){
                    curr = curr.nodes[index];
                }else{
                    curr.nodes[index] = new Node();
                    curr = curr.nodes[index];
                }
            }
        }
        
        
        public boolean prefix(String prefix) {
            Node curr = root;

            for(int i = 0; i < prefix.length(); i++){
                Node next = curr.nodes[prefix.charAt(i) - 'a'];
                if(next != null){
                    curr = next;
                }else{
                    return false;
                }
            }

            return true;
        }

        class Node {
            Node[] nodes = new Node[26];
        }
    }
}