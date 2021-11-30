import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        helper(new ArrayList<String>(), s, partitions, 0);
        return partitions;
    }

    private void helper(ArrayList<String> strings, String s, List<List<String>> partitions, int point) {
        if (s.length() == 0){
            partitions.add(new ArrayList<>(strings));
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            String temp = s.substring(0,i);
            if (isPalindrome(temp)){
                strings.add(temp);
                helper(strings, s.substring(i), partitions, i);
                strings.remove(strings.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
//        System.out.println("Partition: " + ("ab".substring(2)));
        System.out.println(new Scratch().partition("").toString());
    }
}