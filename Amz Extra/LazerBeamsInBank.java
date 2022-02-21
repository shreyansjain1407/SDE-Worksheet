class LazerBeamsInBank {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prev = 0;
        for(String row : bank){
            if(row.contains("1")){
                int sum = 0;
                for(char c : row.toCharArray()){
                    if(c == '1')
                        sum ++;
                }
                totalBeams += prev * sum;
                prev = sum;
            }
        }
        return totalBeams;
    }
}