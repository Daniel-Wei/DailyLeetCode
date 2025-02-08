class FoodRatings {
    HashMap<String, PriorityQueue<Food>> map = new HashMap<>();
    HashMap<String, Food> foodMap = new HashMap<String, Food>();


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for(int i = 0; i < foods.length; i++){
            String cuisine = cuisines[i];

            PriorityQueue<Food> pq = map.getOrDefault(cuisine, 
                new PriorityQueue<Food> ((f1, f2) -> {
                    if(f1.rating == f2.rating){
                        return f1.name.compareTo(f2.name);
                    }

                    return f2.rating - f1.rating;
                }));
               
            Food f = new Food(foods[i], ratings[i], cuisine);
            pq.add(f);
            foodMap.put(foods[i], f);
            map.put(cuisine, pq);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        Food prev = foodMap.get(food);
        Food newFood = new Food(food, newRating, prev.cuisine);
        prev.removed = true;
        map.get(prev.cuisine).add(newFood);
        foodMap.put(food, newFood);

    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = map.get(cuisine);

        while(pq.size() > 0){
            if(pq.peek().removed){
                pq.poll();
            }else{
                return pq.peek().name;
            }
        }
        
        return null;
    }

    private class Food{
        String name;
        String cuisine;
        boolean removed;
        int rating;

        public Food(String name, int rating, String cuisine){
            this.name = name;
            this.removed = false;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */