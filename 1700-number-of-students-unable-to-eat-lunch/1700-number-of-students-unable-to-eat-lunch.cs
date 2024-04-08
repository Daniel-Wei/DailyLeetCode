public class Solution {
    public int CountStudents(int[] students, int[] sandwiches) {
        Queue<int> q = new Queue<int>(students);
        Queue<int> s = new Queue<int>(sandwiches);
        
        int total = students.Length;
        int counter = 0;
        
        while(counter != total){
            int stu = q.Dequeue();
            int sw = s.Peek();
            
            if(stu != sw){
                counter += 1;
                q.Enqueue(stu);
            }else{
                counter = 0;
                total -= 1;
                s.Dequeue();
            }
        }
        
        return total;
    }
}