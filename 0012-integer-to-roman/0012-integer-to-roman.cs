public class Solution {
    public string IntToRoman(int num) {
        Dictionary<int, char> dict = new Dictionary<int, char>();
        
        dict.Add(1, 'I');
        dict.Add(5, 'V');
        dict.Add(10, 'X');
        dict.Add(50, 'L');
        dict.Add(100, 'C');
        dict.Add(500, 'D');
        dict.Add(1000, 'M');
        
        int s = 1000;
        int r = 0;
        int q = 0;
        
        string res = "";
        
        
        while(s != 0){
            r = num % s;
            q = num / s;
            res += Helper(q, s, dict);
            
            num = r;
            s /= 10;
        }
        
        return res;
    }
    
    private string Helper(int q, int s, Dictionary<int, char> dict){
        
        // Console.WriteLine(q);
        // Console.WriteLine(s);
        if(q < 4){
            return new string(dict[s], q);
        }
        else if(q == 4){
            return new string(dict[s] , 1) + new string(dict[s * 5] , 1);
        }
        else if(q == 5){
            return new string(dict[s * 5], 1);
        }
        
        else if(q <= 8){
            string str = new string(dict[s * 5], 1);
            return str + new string(dict[s], q - 5);
        }else{
            return new string(dict[s], 1) + new string(dict[s * 10], 1);
        }
    }
}