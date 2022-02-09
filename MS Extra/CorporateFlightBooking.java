class CorporateFlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        for(int[] booking : bookings){
            seats[booking[0]-1] += booking[2];
            if(booking[1] < n){
                seats[booking[1]] -= booking[2];
            }
        }
        int cur = 0;
        for(int i = 0; i < seats.length; i++){
            cur += seats[i];
            seats[i] = cur;
        }
        return seats;
    }
}