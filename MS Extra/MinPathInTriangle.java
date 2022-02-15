class MinPathInTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)return triangle.get(0).get(0);
        List<Integer> prev = triangle.get(0);
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                if(j == 0){
                    int temp = cur.get(0) + prev.get(0);
                    cur.set(0,temp);
                }else if(j == cur.size() - 1){
                    int temp = cur.get(j) + prev.get(j-1);
                    cur.set(j,temp);
                }else{
                    int temp = cur.get(j);
                    temp += Math.min(prev.get(j-1), prev.get(j));
                    cur.set(j, temp);
                }
            }
            prev = cur;
        }
        int min = Integer.MAX_VALUE;
        for(int num: prev)
            min = Math.min(min, num);
        return min;
    }
}