class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > max){
                list.add(i);
                max = heights[i];
            }
        }
        int[] arr = new int[list.size()];
        for(int i = arr.length - 1; i >= 0; i--){
            arr[arr.length - i - 1] = list.get(i);
        }
        return arr;
    }
}