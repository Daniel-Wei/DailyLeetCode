public class Solution {
    public int[] RelativeSortArray(int[] arr1, int[] arr2) {
        int[]counting = new int[arr2.Length];
        List<int>res1 = new List<int>();
        List<int>res2 = new List<int>();
        
        Dictionary<int, int> pos = new Dictionary<int, int>();
        
        for(int i = 0; i < arr2.Length; i++){
            pos.Add(arr2[i], i);
        }
        
        foreach(int num in arr1){
            if(pos.ContainsKey(num)){
                counting[pos[num]] += 1;
            }else{
                res2.Add(num);
            }
        }
        
        res2.Sort();
        
        for(int i = 0; i < counting.Length; i++){
            int c = counting[i];
            
            for(int j = 0; j < c; j++){
                res1.Add(arr2[i]);
            }
        }
        
        res1.AddRange(res2);
        
        return res1.ToArray();
    }
}