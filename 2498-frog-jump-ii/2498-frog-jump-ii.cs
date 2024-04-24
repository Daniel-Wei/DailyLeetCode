//Claim 1: It is optimal that we make use of all rocks: There is never a benefit of not including a rock in Path 1 or Path 2, //it is always positive or neutral.

// Claim 2: It is never optimal to choose two consecutive rocks: If we choose rock_i, and rock_i+1, then rock_i+2 will have to do (rock_i+2)-(rock_i) work to return. Because the array is strictly increasing, it holds that (rock_i+2)-(rock_i) > (rock_i+1-rock_i)

// 最佳方式是不skip 然而只能jump to any stone at most once
// skip的越多 回来的时候牺牲越大
// 所以每次只skip一个

public class Solution {
    public int MaxJump(int[] stones) {
        int res = stones[1] - stones[0];
        
        for(int i = 1; i < stones.Length - 1; i++){
            res = Math.Max(res, stones[i+1] - stones[i-1]);
        }
        
        return res;
    }
}