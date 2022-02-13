class BrightestPoint {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> brightness = new TreeMap<>();
        for(int[] light : lights){
            brightness.put(light[0] - light[1], brightness.getOrDefault(light[0] - light[1], 0) + 1);
            brightness.put(light[0] + light[1] + 1, brightness.getOrDefault(light[0] + light[1] + 1, 0) - 1);
        }
        int brightest = Integer.MIN_VALUE;
        int curBr = 0;
        int brightIndex = Integer.MIN_VALUE;
        for(int key : brightness.keySet()) {
            curBr += brightness.get(key);
            if(curBr > brightest){
                brightIndex = key;
                brightest = curBr;
            }
        }
        return brightIndex;
    }
}