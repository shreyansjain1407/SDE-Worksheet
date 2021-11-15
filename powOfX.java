class powOfX {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1, product = x;
        for(long i = N; i > 0; i/=2){
            if(i%2 == 1)ans *= product;
            product *= product;
        }
        
        return ans;
    }
}

/*
    public double myPow(double x, int n) {
        double N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        for(int i = 0; i < N; i++){
            ans = ans * x;
        }
        
        return ans;
    }
*/