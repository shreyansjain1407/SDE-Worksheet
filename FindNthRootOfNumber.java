class FindNthRootOfNumber{
    public double nthRoot(int root, int number){
        if(number == 1 || root == 0)
            return 1;
        
        double left = 1, right = number;
        double prev = -1, prevMid = -1;
        while(left < right){
            double mid = (right+left)/2;
            double pow = Math.pow(mid,root);
            if(prev == pow)
                break;
            System.out.println(pow);
            if(pow == number){
                return mid;
            }else if(pow < number){
                left = mid;
            }else {
                right = mid;
            }
            prev = pow;
            prevMid = mid;
        }
        return (Math.round(prev) == number)?prevMid:-1;
    }

    public static void main(String[] args) {
        System.out.println(new FindNthRootOfNumber().nthRoot(5,27));
    }
}