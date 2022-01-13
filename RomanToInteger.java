class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        int output = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length()-1){
                if(romans.get(s.charAt(i)) < romans.get(s.charAt(i+1))){
                    output += romans.get(s.charAt(i+1)) - romans.get(s.charAt(i));
                    i++;
                    continue;
                }
            }
            output += romans.get(s.charAt(i));
        }
        return output;
    }
}