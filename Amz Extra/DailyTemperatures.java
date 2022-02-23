class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int[] greaterTemps = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!temp.isEmpty() && temperatures[temp.peek()] <= temperatures[i]){
                temp.pop();
            }
            if(temp.isEmpty()){
                greaterTemps[i] = 0;
            }else{
                greaterTemps[i] = temp.peek() - i;
            }
            temp.push(i);
        }
        return greaterTemps;
    }
}