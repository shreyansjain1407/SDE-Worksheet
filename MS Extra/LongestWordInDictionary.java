class LongestWordInDictionary {
    public String findLongestWord(String s, List<String> dictionary) {
        String curMax = "";
        for(String str : dictionary){
            if(isSubsequence(str, s)){
                if(str.length() > curMax.length() || str.length() == curMax.length() && str.compareTo(curMax) < 0){
                    curMax = str;
                }
            }
        }
        return curMax;
    }

    private boolean isSubsequence(String str, String s) {
        int x = 0;
        for(int i = 0; i < s.length() && x < str.length(); i++){
            if(s.charAt(i) == str.charAt(x)){
                x++;
            }
        }

        return x == str.length();
    }
}