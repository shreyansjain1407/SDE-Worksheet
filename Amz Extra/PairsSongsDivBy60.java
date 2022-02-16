class PairsSongsDivBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] modulo = new int[60];
        int count = 0;
        for(int t : time){
            if(t % 60 == 0)
                count += modulo[0];
            else{
                count += modulo[60 - t%60];
            }
            modulo[t%60]++;
        }
        return count;
    }
}