class CoinChangeMinCoins {
    public int minCoins(int[] coins, int amount){
        int[] dynamic = new int[amount+1];
        Arrays.fill(dynamic, amount+1);
        dynamic[0] = 0;
        for(int i = 1; i < dynamic.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i)
                    dynamic[i] = Math.min(dynamic[i], dynamic[i - coins[j]] + 1);
            }
        }
        return dynamic[amount] > amount ? -1 : dynamic[amount];
    }
    public static void main(String[] args) {
        System.out.println(new Scratch().minCoins(new int[]{2}, 11));
    }
}