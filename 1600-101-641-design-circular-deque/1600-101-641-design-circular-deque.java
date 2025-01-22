class MyCircularDeque {
    private int[] memo;
    private int front;
    private int last;
    private int k;

    public MyCircularDeque(int k) {
        this.memo = new int[k];
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(!this.isFull()){
            this.memo[this.front] = value;
            this.front++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertLast(int value) {
        if(!this.isFull()){
            this.memo[this.k - 1 - this.last] = value;
            this.last++;
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean deleteFront() {

        if(this.isEmpty()){
            return false;
        }else{
            if(this.front > 0){
                this.front--;
            }else{
                for(int i = this.k - 1; i > this.k - this.last; i--){
                    this.memo[i] = this.memo[i - 1];
                }
                this.last--;
            }

            return true;
        }
    }
    
    public boolean deleteLast() {
        if(this.isEmpty()){
            return false;
        }else{
            if(this.last > 0){
                this.last--;
            }else{
                for(int i = 0; i < this.front; i++){
                    this.memo[i] = this.memo[i + 1];
                }
                this.front--;
            }

            return true;
        }
        
    }
    
    public int getFront() {
        int res = -1;
        if(!this.isEmpty()){
            if(this.front > 0){
                res = this.memo[this.front - 1];
            }else{
                res = this.memo[this.k - 1];
            }
        }

        return res;
        
    }
    
    public int getRear() {
        int res = -1;
        if(!this.isEmpty()){
            if(this.last > 0){
                res = this.memo[this.k - this.last];
            }else{
                res = this.memo[0];
            }
        }

        return res;
    }
    
    public boolean isEmpty() {
        return front + last == 0;
        
    }
    
    public boolean isFull() {
        return this.front + this.last >= this.k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */