class CoinChangeTotalCombinations {
    public int minCoins(int[] coins, int amount){
        int[] dynamic = new int[amount+1];
        dynamic[0] = 1;
        for(int coin : coins){
            for(int i = 0; i < dynamic.length; i++){
                if(i >= coin){
                    dynamic[i] += dynamic[i-coin];
                }
            }
        }
        return dynamic[amount];
    }
    public static void main(String[] args) {
        System.out.println(new Scratch().minCoins(new int[]{1,2,5}, 12));
    }
}