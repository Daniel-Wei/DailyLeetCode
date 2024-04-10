public class Solution {
    // Use Queue to reverse the whole game process
    public int[] DeckRevealedIncreasing(int[] deck) {
        if(deck.Length == 1){
            return deck;
        }
        
        Queue<int> q= new Queue<int>();
        Array.Sort(deck, (a, b) => b.CompareTo(a));
        q.Enqueue(deck[0]);
        q.Enqueue(deck[1]);
        
        for(int i = 2; i < deck.Length; i++){
            int curr = q.Peek();
            q.Dequeue();
            q.Enqueue(curr);
            q.Enqueue(deck[i]);
        }
        
        int[]res = q.ToArray();
        Array.Reverse(res);
        
        return res;
    }
}