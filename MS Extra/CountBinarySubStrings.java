class CountBinarySubStrings {
    public int countBinarySubstrings(String s) {
        int[] arr = new int[s.length()];
        int arri = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int j = i+1;
            while(j < s.length()){
                if(s.charAt(j) == c){
                    j++;
                }else{
                    break;
                }
            }
            arr[arri++] = j-i;
            i = j;
        }
        int count = 0;
        for(int x = 0; x < arri-1; x++){
            count += Math.min(arr[x], arr[x+1]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBinarySubstrings("10"));
        System.out.println(new Solution().countBinarySubstrings("010101010101"));
    }
}