class MaxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int units = 0, boxes = 0;
        for(int i = 0; i < boxTypes.length && truckSize >0; i++){
            int[] box = boxTypes[i];
            if(box[0] <= truckSize){
                units += box[0] * box[1];
                truckSize -= box[0];
            }else{
                units += truckSize * box[1];
                truckSize = 0;
            }
        }
        return units;
    }
}