class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int asteroid : asteroids){
            if(stack.isEmpty()){
                stack.push(asteroid);
            }else{
                if(asteroid < 0){
                    int abs = Math.abs(asteroid);
                    while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < abs){
                        stack.pop();
                    }
                    if(stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                        continue;
                    }
                    if(stack.peek() == abs){
                        stack.pop();
                    }
                }else{
                    stack.push(asteroid);
                }
            }
        }

        int[] space = new int[stack.size()];
        int n = stack.size() - 1;
        while (!stack.isEmpty())
            space[n--] = stack.pop();
        return space;
    }
}