class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = ''.join(' ' if c in string.punctuation else c for c in paragraph).lower()
        
        
       
        for word in set(banned):
            paragraph = paragraph.replace(word, "")
            
        print(paragraph)
            
        words = paragraph.split()
        freq = {}
        
        for word in words:
            if word in freq:
                freq[word] += 1
            else:
                freq[word] = 1
               
        print(words)
        h = []
        heapq.heapify(h)
        for word in set(words):
            print()
            heapq.heappush(h, (freq[word], word))
            
        return heapq.nlargest(1, h)[0][1]
            
        
            
            