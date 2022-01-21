class LetterCombinationsOfPhoneNumber {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)return new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> combinations = new ArrayList<>();
        helper(combinations, new StringBuilder(), 0, digits);
        return combinations;
    }

    private void helper(List<String> combinations, StringBuilder stringBuilder, int curIndex, String digits) {
        if(curIndex == digits.length()){
            combinations.add(stringBuilder.toString());
            return;
        }
        String cur = map.get(digits.charAt(curIndex));
        for(int i = 0; i < cur.length(); i++){
            stringBuilder.append(cur.charAt(i));
            helper(combinations, stringBuilder, curIndex+1, digits);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().letterCombinations(""));
    }
}