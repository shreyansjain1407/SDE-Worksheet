class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        Set<String> outputList = new HashSet<>();
        helper(outputList, 0, 0, n, new StringBuilder());
        return new ArrayList<>(outputList);
    }

    private void helper(Set<String> outputList, int open, int close, int n, StringBuilder sb) {
//        if(close > open)return;
        if(open == n && close == n){
            outputList.add(sb.toString());
            return;
        }
        for(int i = 0; i < open-close; i++){
            sb.append(")".repeat(i+1));
            helper(outputList, open, close + i+ 1, n, sb);
            sb.setLength(sb.length() - (i+1));
        }
        for(int i = 0; i < n-open; i++){
            sb.append("(".repeat(i+1));
            helper(outputList, open + i + 1, close, n, sb);
            sb.setLength(sb.length() - (i+1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().generateParenthesis(4));
    }
}