class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        for(int i = 0; i < numRows; i++){
            addList(i);
        }
        return out;
    }
    
    public void addList(int i){
        List<Integer> current = new ArrayList<>();
        
        if(i == 0){
            current.add(1);
            //out.add(current);
        }
        if(i == 1){
            current.add(1);current.add(1);
            //out.add(current);
        }
        if(i>1){
            current.add(1);
            for(int j = 1; j < i; j++){
                List<Integer> pre = out.get(i-1);
                current.add(pre.get(j-1)+pre.get(j));
            }
            current.add(1);
        }
        out.add(current);
    }
}