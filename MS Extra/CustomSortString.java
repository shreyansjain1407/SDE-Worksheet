class CustomSortString {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            sb.append(Character.toString(c).repeat(arr[c-'a']));
            arr[c-'a'] = 0;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                sb.append(Character.toString(i + 'a').repeat(arr[i]));
            }
        }
        return sb.toString();
    }
}