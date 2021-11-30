import java.util.ArrayList;
import java.util.List;

class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        System.out.println("List Initially: " + list);
        int result = k;
        while(list.size() > 0){
            int curFact = factorial(list.size());
            int div = curFact/list.size();
            int curLoc = (int)Math.ceil((double)result/div);
            System.out.println("CurFact: " + curFact + " Div: " + div + " curLoc: " + curLoc);
//            System.out.println(list.get(curLoc));
            stringBuilder.append(list.remove(curLoc - 1));
            boolean reverse = result % div == 0;
            result = result % div;
            if(result == 0){
                if(reverse){
                    for(int i = list.size() -1; i >= 0; i--){
                        stringBuilder.append(list.get(i));
                    }
                }else {
                    while (list.size() > 0) {
                        System.out.println("List Inside while loop: " + list);
                        stringBuilder.append(list.remove(0));
                    }
                }
                break;
            }
        }
        return stringBuilder.toString();
    }

    public int factorial(int n){
        int x = 1;
        for(int i = n; i > 0; i--)
            x *= i;
        return x;
    }

    public static void main(String[] args) {
//        System.out.println("Partition: " + ("ab".substring(2)));
        System.out.println(new Scratch().getPermutation(3,2));
    }
}