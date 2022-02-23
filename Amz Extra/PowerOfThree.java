class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n,3).matches("^10*$");
    }
}

class Solution { 
//21033 / 21028 Test Cases Passed
    public boolean isPowerOfThree(int n) {
        if(n < 0)return false;
        double pow = Math.log(n) / Math.log(3);
        return pow == (int) pow;
    }
}