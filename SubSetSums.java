class SubSetSums{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> set = new ArrayList<>();
        set.add(0);
        helper(set, new ArrayList<Integer>(), 0, arr);
        return set;
    }

    private void helper(ArrayList<Integer> set, ArrayList<Integer> objects, int start, ArrayList<Integer> arr) {
        int sum = 0;
        for (int num : objects){
            sum += num;
        }
        set.add(sum);
        for (int i = start; i < arr.size(); i++){
            objects.add(arr.get(i));
            helper(set,objects, i+1,arr);
            objects.remove(objects.size()-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(){{
            add(5);
            add(2);
            add(1);
        }};
        System.out.println(new Solution().subsetSums(list,list.size()).toString());
    }
}