class ExpressionAddOperator {
    public List<String> addOperators(String num, int target) {
        List<String> out = new ArrayList<>();
        char[] number = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(number[0]);
        backTrack(out, number, target, number[0] - '0', sb, 1);
        return out;
    }

    private void backTrack(List<String> out, char[] number, int target, int current, StringBuilder sb, int index) {
        if(index == number.length){
            if(current == target)
                out.add(sb.toString());
            return;
        }
        char[] operations = {'+', '*', '-'};
        for(char c : operations){
            if(c == '+'){
                int cur = current + (number[index] - '0');
                sb.append('+').append(number[index]);
                backTrack(out, number, target, cur, sb, index+1);
                sb.setLength(sb.length()-2);
            }else if(c == '-'){
                int cur = current - (number[index] - '0');
                sb.append('-').append(number[index]);
                backTrack(out, number, target, cur, sb, index+1);
                sb.setLength(sb.length()-2);
            }else{
                int cur = current * (number[index] - '0');
                sb.append('*').append(number[index]);
                backTrack(out, number, target, cur, sb, index+1);
                sb.setLength(sb.length()-2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("232", 8));
    }
}