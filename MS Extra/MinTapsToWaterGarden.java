class MinTapsToWaterGarden {
    public int minTaps(int n, int[] ranges) {
        int[] ends = new int[ranges.length + 1];
        for(int i = 0; i < ranges.length; i++){
            int st = Math.max(0, i - ranges[i]);
            int en = Math.min(n, i + ranges[i]);
            if(st == 0 && en == n)
                return 1;
            ends[st] = Math.max(ends[st], en);
        }

        int curEnd = ends[0], index = 0, nxtEnd = curEnd, count = 0;
        while (index <= curEnd){
            nxtEnd = Math.max(nxtEnd, ends[index]);
            if(index == curEnd){
                curEnd = nxtEnd;
                count++;
            }
            index++;
        }

        return curEnd == n ? count : -1;
    }
}