class TotalConnections {
    public int numberOfConnections (List<List<Integer>> grid) {
        int totalConnections = 0, prev = 0;
        for(List<Integer> list : grid){
            int count = 0;
            for (Integer num : list){
                if(num == 1){
                    count++;
                }
            }
            if(count != 0){
                totalConnections += prev * count;
                prev = count;
            }
        }
        return totalConnections;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1,1,1));
        grid.add(Arrays.asList(0,1,0));
        grid.add(Arrays.asList(0,0,1));
        grid.add(Arrays.asList(1,1,1));
        System.out.println(new Connections().numberOfConnections(grid));
    }
}