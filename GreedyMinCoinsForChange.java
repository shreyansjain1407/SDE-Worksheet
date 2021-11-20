import java.util.Arrays;
import java.util.Collections;

class GreedyMinCoinsForChange {

    public boolean getMinCoins(int[] denominations, int change){
        Arrays.sort(denominations);
        int i = denominations.length - 1;
        while(i >= 0 && change != 0){
            if(denominations[i] <= change){
                change -= denominations[i];
            }else {
                i--;
            }
        }
        return (change == 0);
    }

    public static void main(String[] args) {
        int[] arr = new int[15];
        System.out.println(new GreedyMinCoinsForChange().getMinCoins(arr), 15);
    }
}