class ProductOfNumbers {
    List<Integer> prefixSum = new ArrayList<Integer>();

    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        if(num == 0){
            prefixSum = new ArrayList<Integer>();
        }else if(prefixSum.size() == 0){
            prefixSum.add(num);
        }
        else{
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixSum.size();
        if(k > size){
            return 0;
        }else if(k == size){
            return prefixSum.get(size - 1);
        }
        else{
            return prefixSum.get(size - 1) / prefixSum.get(size - k - 1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */