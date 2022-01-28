class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] outputArr = new int[length];
        for(int[] update : updates){
            outputArr[update[0]] += update[2];
            if(update[1] + 1 < length){
                outputArr[update[1] + 1] -= update[2];
            }
        }
        int update = 0;
        for(int i = 0; i < length; i++){
            update += outputArr[i];
            outputArr[i] = update;
        }
        return outputArr;
    }
}