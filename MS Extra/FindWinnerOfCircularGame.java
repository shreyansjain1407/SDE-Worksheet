class FindWinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = 0;
        while(list.size() != 1){
            cur += k - 1;
            cur %= list.size();
            // System.out.println("Removed Friend: " + (list.get(cur)+1));
            list.remove(cur);
        }
        
        return list.get(0) + 1;
    }
}