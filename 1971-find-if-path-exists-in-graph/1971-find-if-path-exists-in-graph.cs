public class Solution {
        public bool ValidPath(int n, int[][] edges, int source, int destination)
        {
            var adjacencyList = GetAdjacencyList(edges);
            bool[] visited = new bool[n];
            Stack<int> stack = new Stack<int>();
            stack.Push(source);

            while (stack.Count > 0)
            {
                var top = stack.Pop();
                visited[top] = true;

                if (top == destination)
                    return true;

                foreach(var neighbour in adjacencyList.GetValueOrDefault(top))
                {
                    if(!visited[neighbour])
                        stack.Push(neighbour);
                }
            }
            return false;
        }

        private Dictionary<int, List<int>> GetAdjacencyList(int[][] edges)
        {
            var adjacencyList = new Dictionary<int, List<int>>();

            for (int v = 0; v < edges.Length; v++)
            {
                if (adjacencyList.ContainsKey(edges[v][0]))
                    adjacencyList.GetValueOrDefault(edges[v][0]).Add(edges[v][1]);
                else
                    adjacencyList[edges[v][0]] = new List<int>() { edges[v][1] };

                if (adjacencyList.ContainsKey(edges[v][1]))
                    adjacencyList.GetValueOrDefault(edges[v][1]).Add(edges[v][0]);
                else
                    adjacencyList[edges[v][1]] = new List<int>() { edges[v][0] };
            }
            return adjacencyList;
        }
}