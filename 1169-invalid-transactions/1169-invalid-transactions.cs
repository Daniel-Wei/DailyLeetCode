public class Solution {
    
    private class Transaction(){
        public string Name {get; set;}
        public int Time {get; set;}
        public int Amount {get; set;}
        public string City {get; set;}
        public int Index {get; set;}
    }
    
    public IList<string> InvalidTransactions(string[] transactions) {
        IList<string> res = new List<string>();
        HashSet<int>indices = new HashSet<int>();
        Dictionary<string, List<Transaction>> dict = new Dictionary<string, List<Transaction>>();

        for(int i = 0; i < transactions.Length; i++){
            string[]details = transactions[i].Split(',');
            
            Transaction t = new Transaction(){
                Name = details[0],
                Time = Int32.Parse(details[1]),
                Amount = Int32.Parse(details[2]),
                City = details[3],
                Index = i
            };
            
            if(dict.ContainsKey(t.Name)){
                dict[t.Name].Add(t);
            }else{
                dict.Add(t.Name, new List<Transaction>{t});
            }
            
            if(t.Amount > 1000){
                indices.Add(i);
            }
        }
        
        foreach(string name in dict.Keys){
            List<Transaction> trans = dict[name];
            
            for(int i = 0; i < trans.Count; i++){
                Transaction curr = trans[i];
                
                bool invalid = false;
                
                for(int j = 0; j < trans.Count; j++){
                    if(j != i){
                        Transaction t = trans[j];
                        if(Math.Abs(t.Time - curr.Time) <= 60 && t.City != curr.City){
                            indices.Add(t.Index);
                            invalid = true;
                        }
                    }
                }
                
                if(invalid){
                    indices.Add(curr.Index);
                }
            }
        }
        
        foreach(int index in indices){
            res.Add(transactions[index]);
        }
        
        
        return res;
    }
}