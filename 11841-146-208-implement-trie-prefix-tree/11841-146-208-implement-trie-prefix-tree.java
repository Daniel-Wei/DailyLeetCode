class Trie {
    Node root = new Node();

    public Trie() {

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

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        int n = word.length();

        for(int i = 0; i < n; i++){
            Node next = curr.nodes[word.charAt(i) - 'a'];
            if(next != null){
                curr = next;
            }else{
                return false;
            }
        }

        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
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
        boolean isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */