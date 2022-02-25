class MinHealthForCompletingRounds {
    public long findHeadth(List<Integer> power, int armor){
        long totalHealth = 0;
        long curMax = Integer.MIN_VALUE;
        for(int i : power){
            totalHealth += i;
            curMax = Math.max(curMax, i);
        }
        if(armor <= curMax){
            totalHealth -= armor;
        }else{
            totalHealth -= (curMax-armor);
        }
        return totalHealth + 1;
    }
    public static void main(String[] args) {
        System.out.println(new Scratch().findHeadth(Arrays.asList(1,2,6,7), 5));
        System.out.println(new Scratch().findHeadth(Arrays.asList(1,2,3), 1));
    }
}