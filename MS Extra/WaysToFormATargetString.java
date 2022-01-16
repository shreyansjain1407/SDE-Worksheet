class WaysToFormATargetString {
    // 39 / 89 Time Limit Exceeded
    public int numWays(String[] words, String target) {
        List<String> verified = new ArrayList<>();
        helper(words, target, verified, 0, new StringBuilder());
        return verified.size();
    }

    private void helper(String[] words, String target, List<String> verified, int index, StringBuilder sb) {
        if(sb.toString().equals(target)){
            verified.add(sb.toString());
            return;
        }
        if(index == words[0].length()){
            return;
        }

        for(String word : words){
            for (int i = index; i < word.length(); i++){
                if(word.charAt(i) == target.charAt(sb.length())){
                    sb.append(word.charAt(i));
                    helper(words, target, verified, i + 1, sb);
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
}

//Using Lambda Function which leetcode doesn't quite understand I guess
class Solution {
    int count = 0;
    public int numWays(String[] words, String target) {
        List<String> verified = new ArrayList<>();
        helper(Arrays.asList(words), target, 0, new StringBuilder());
        return count;
    }

    private void helper(List<String> words, String target, int index, StringBuilder sb) {
        if(sb.toString().equals(target)){
            count++;
            return;
        }
        if(index == words.get(0).length()){
            return;
        }
        words.parallelStream().forEach((i) -> fxn(i, words, target, sb, index));
    }

    private void fxn(String word, List<String> words, String target, StringBuilder sb, int index) {
        for (int i = index; i < word.length(); i++){
            if(word.charAt(i) == target.charAt(sb.length())){
                sb.append(word.charAt(i));
                helper(words, target, i + 1, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}