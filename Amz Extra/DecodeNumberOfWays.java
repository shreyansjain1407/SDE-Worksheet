class DecodeNumberOfWays {
    public int numDecodings(String s) {
        int[] dynamic = new int[s.length() + 1];
        dynamic[0] = 1;
        dynamic[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            if(!(s.charAt(i-1) == '0')){
                dynamic[i] = dynamic[i-1];
            }

            int two = Integer.parseInt(s.substring(i-2, i));
            if(two >= 10 && two <= 26){
                dynamic[i] += dynamic[i-2];
            }
        }
        return dynamic[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("06"));
    }
}