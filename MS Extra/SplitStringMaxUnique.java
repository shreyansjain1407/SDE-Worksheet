class SplitStringMaxUnique {
    public int maxUniqueSplit(String s) {
        return helper(s, new HashSet<String>());
    }

    private int helper(String s, HashSet<String> strings) {
        if(s.length() == 0){
            return strings.size();
        }
        int uniques = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(!strings.contains(sb.toString())){
                strings.add(sb.toString());
                uniques = Math.max(uniques, helper(s.substring(i), strings));
                strings.remove(sb.toString());
            }
        }
        return uniques;
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().maxUniqueSplit("wwwzfvedwfvhsww"));
    }
}

// 76 / 95v test cases passes
// public int maxUniqueSplit(String s) {
//     Set<String> splits = new HashSet<String>();
//     int i = 0;
//     while(i < s.length()){
//         int x = i+1;
//         boolean incr = true;
//         while(x <= s.length()){
//             if(!splits.contains(s.substring(i, x))){
//                 splits.add(s.substring(i, x));
//                 i = x;
//                 incr = false;
//                 break;
//             }else {
//                 x++;
//             }
//         }
//         if(incr)i++;
//     }
//     return splits.size();
// }