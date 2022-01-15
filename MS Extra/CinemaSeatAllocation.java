class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> filledRows = new HashMap<>();
        for(int i = 0; i < reservedSeats.length; i++){
            int row = reservedSeats[i][0] - 1;
            int seat = reservedSeats[i][1];
            int availableGroup = filledRows.getOrDefault(row, 0);
            if(seat == 1 || seat == 10){
                continue;
            }else if(seat == 2 || seat == 3){
                availableGroup |= 1;
            }else if(seat > 3 && seat < 6){
                availableGroup |= 3;
            }else if(seat > 5 && seat < 8){
                availableGroup |= 6;
            }else if(seat == 8 || seat == 9){
                availableGroup |= 4;
            }
            filledRows.put(row, availableGroup);
        }
        int openReservations = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,2);
        map.put(1,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        map.put(6,1);
        map.put(7,0);
        for(int row : filledRows.values()){
            openReservations += map.getOrDefault(row,0);
        }
        return openReservations + (n - filledRows.size())*2;
    }
}