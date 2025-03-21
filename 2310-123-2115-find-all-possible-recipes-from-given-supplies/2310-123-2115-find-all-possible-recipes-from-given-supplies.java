class Solution {
    // public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    //     HashSet<String> supplySet = new HashSet<String>();

    //     for(String s : supplies){
    //         supplySet.add(s);
    //     }
        
        
    //     List<String> result = new ArrayList<String>();
    //     List<Integer> nextRound = new ArrayList<Integer>();

    //     for(int i = 0; i < recipes.length; i++) {
    //         List<String> currIngredients = ingredients.get(i);
    //         boolean canMake = true;
            
    //         for(int j = 0; j < currIngredients.size(); j++) {
    //             if(!supplySet.contains(currIngredients.get(j))) {
    //                 canMake = false;
    //             }else{
    //                 currIngredients.set(j, null);
    // }			
    //         }

    //         if(canMake) {
    //             supplySet.add(recipes[i]);
    //             result.add(recipes[i]);
    //         }else{
    //             nextRound.add(i);
    //         }
    //     }

    //     while(nextRound.size() != 0) {
    //         List<Integer> futureRound = new ArrayList<Integer>();
            
    //         for(int i : nextRound) {
    //             List<String> currIngredients = ingredients.get(i);
    //             boolean canMake = true;

    //             for(int j = 0; j < currIngredients.size(); j++) {
    //                 if(currIngredients.get(j) != null) {
    //                     if(!supplySet.contains(currIngredients.get(j))){
    //                         canMake = false;
    //                     }else{
    //                         currIngredients.set(j, null);
    //                     }
    //                 }
    //             }

    //             if(canMake) {
    //                 supplySet.add(recipes[i]);
    //                 result.add(recipes[i]);
    //             }else{
    //                 futureRound.add(i);
    //             }
    //         }

    //         if(futureRound.size() == nextRound.size()) {
    //             break;
    //         }

    //         nextRound = futureRound;
    //     }

    //     return result;

    // }

    public List<String> findAllRecipes (String[] recipes, List<List<String>> ingredients, String[] supplies) 
    {
        Queue<String> q = new LinkedList<String>();

        for(String s : supplies) {
            q.offer(s);
        }
        HashMap<String, Integer> recipeDegrees = new HashMap<>();
        HashMap<String, List<String>> ingredientToRecipes = new HashMap<>();

        for(int i = 0; i < recipes.length; i++) {
            List<String> currIngredients = ingredients.get(i);
            recipeDegrees.put(recipes[i], currIngredients.size());
            
            for(String curr : currIngredients) {
                List<String> currRecipes = ingredientToRecipes.getOrDefault(curr, new ArrayList<String>());
                currRecipes.add(recipes[i]);
                ingredientToRecipes.put(curr, currRecipes);
            }
        }

        List<String> result = new ArrayList<String>();

        while(q.size() != 0) {
            String supply = q.poll();
            List<String> affectedRecipes = ingredientToRecipes.getOrDefault(supply, new ArrayList<String>());

            for(String r : affectedRecipes) {
                int degree = recipeDegrees.get(r);
                degree -= 1;
                if(degree == 0) {
                    q.offer(r);
                    result.add(r);
                }else{
                    recipeDegrees.put(r, degree);
                }
            }
        }

        return result;
    }

}