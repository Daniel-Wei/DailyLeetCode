class Solution {
   public String[] reorderLogFiles(String[] logs) {
            ArrayList<String> letLogs= new ArrayList<String>();
            ArrayList<String> digLogs= new ArrayList<>();
            for(String log : logs){

                if(Character.isDigit(log.charAt(log.length() - 1))){
                    digLogs.add(log);
                }
                else{
                    letLogs.add(log);
                }
            }

            Collections.sort(letLogs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1.substring(o1.indexOf(" ") + 1);
                    String s2 = o2.substring(o2.indexOf(" ") + 1);
                    String i1 = o1.substring(0, o1.indexOf(" "));
                    String i2 = o2.substring(0, o2.indexOf(" "));
//                    System.out.println("o1: " + o1);
//                    System.out.println("o2: " + o2);
//                    System.out.println("s1: " + s1);
//                    System.out.println("s2: " + s2);
//                    System.out.println("i1: " + i1);
//                    System.out.println("i2: " + i2);

                    if((s1.compareTo(s2)) > 0){
                        return 1;
                    }else if((s1.compareTo(s2)) == 0){
                        if(i1.compareTo(i2) > 0){
                            return 1;
                        }

                    }

                    return -1;
                }
            });

//            System.out.println("let logs: " + letLogs);
//            System.out.println("diglogs: " + digLogs);

            digLogs.forEach(digLog -> letLogs.add(digLog));
            // letLogs.forEach(ele -> System.out.println(ele));
            return letLogs.toArray(String[]::new);
        }
}