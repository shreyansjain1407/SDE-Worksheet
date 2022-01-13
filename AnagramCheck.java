class AnagramCheck {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] s_arr = new int[26];
        int[] t_arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            s_arr[s.charAt(i) - 'a']++;
            t_arr[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s_arr.length; i++){
            if(s_arr[i] != t_arr[i])
                return false;
        }

        return true;
    }
}