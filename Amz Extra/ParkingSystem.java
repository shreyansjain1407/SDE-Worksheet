class ParkingSystem {
    int big,medium,small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1){
            return big-- >= 0;
        }else if(carType == 2){
            return medium-- >= 0;
        }else{
            return small-- >= 0;
        }
    }
}