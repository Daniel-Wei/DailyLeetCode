public class Solution {
    //使用Binary Search剪枝
    public int MaximumTastiness(int[] price, int k) {
        Array.Sort(price);
        int l = 0;
        int r = price[price.Length - 1] - price[0];
        int mid = 0;
        int ans = 0;
        
        while(l <= r){
            mid = (l + r) / 2;
            
            // Debug
            // Console.WriteLine(l);
            // Console.WriteLine(r);
            // Console.WriteLine(mid);
            // Console.WriteLine();
            
            if(Helper(price, mid, k)){
                l = mid + 1;
                ans = mid;
            }else{
                r = mid - 1;
            }
        }
        
        return ans;
    }
    
    private bool Helper(int[]price, int mid, int k){
        
        int prev = price[0];
        int count = 1;
        for(int i = 1; i < price.Length; i++){
            if(price[i] - prev >= mid){
                count++;
                if(count == k){
                    return true; //剪枝
                }else{
                    prev = price[i];//need to make sure each pair satisfied 
                }
            }
        }
        
        return false;
    }
}