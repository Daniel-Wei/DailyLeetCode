class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:

        def shortest(char: str) -> dict:

            char2cost = defaultdict(lambda : float('inf'))

            heap = [[0, char]] # queue of [cur_cost, cur_char]
            while heap:
                cur_cost, cur_char = heapq.heappop(heap)
                if char2cost[cur_char] <= cur_cost:
                    continue
                char2cost[cur_char] = cur_cost
                
                for adj, nxt_cost in char2adj_cost[cur_char]:
                    heapq.heappush(heap, [cur_cost + nxt_cost, adj])
            
            return char2cost


        char2adj_cost = defaultdict(list)

        for i in range(len(cost)):
            if original[i] == changed[i]:
                continue
            char2adj_cost[original[i]].append([changed[i], cost[i]])

        char2end_cost = dict()
        for char in original:
            if char not in char2end_cost:
                char2end_cost[char] = shortest(char)
        
        ans = 0
        for i in range(len(source)):
            if source[i] == target[i]:
                continue
            if source[i] not in char2end_cost or target[i] not in char2end_cost[source[i]]:
                return -1
            ans += char2end_cost[source[i]][target[i]]
        
        return ans