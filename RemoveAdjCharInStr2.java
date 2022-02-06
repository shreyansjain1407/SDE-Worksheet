class Pair{
    int freq;
    char ch;

    public Pair(char ch) {
        this.ch = ch;
        this.freq = 1;
    }
}
class RemoveAdjCharInStr2 {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair(cur));
            }else{
                if(cur == stack.peek().ch){
                    stack.peek().freq++;
                    if(stack.peek().freq == k)
                        stack.pop();
                }else{
                    stack.push(new Pair(cur));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair temp = stack.pop();
            sb.append(String.valueOf(temp.ch).repeat(temp.freq));
        }
        return sb.reverse().toString();
    }
}