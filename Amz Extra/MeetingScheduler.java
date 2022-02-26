class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a,b) -> a[0] - b[0]);
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < slots1.length && ptr2 < slots2.length){
            int[] slt1 = slots1[ptr1];
            int[] slt2 = slots2[ptr2];
            int st = Math.max(slt1[0], slt2[0]);
            int end = Math.min(slt1[1], slt2[1]);
            if(end - st >= duration){
                return new ArrayList<>(Arrays.asList(st, st+duration));
            }
            if(slt1[1] < slt2[1]){
                ptr1++;
            }else{
                ptr2++;
            }
        }
        return new ArrayList<>();
    }
}