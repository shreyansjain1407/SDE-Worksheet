public class repeatAndMissing {

    public int[] repeatedNumber(final int[] arr) {
        int xor1 = 0;
        for (int j : arr) xor1 ^= j;
        for (int i = 1; i <= arr.length; i++)
            xor1 ^= i;

        int set_bit = xor1 & -xor1;
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++){
            if((set_bit & arr[i]) != 0)
                x ^= arr[i];
            else
                y ^= arr[i];
        }
        for (int i = 1; i <= arr.length; i++){
            if((set_bit & i) != 0)
                x ^= i;
            else
                y ^= i;
        }
        Integer found = null;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) {
                found = x;
                break;
            }
        }
        if(found != null){
            return new int[]{found, y};
        }else{
            return  new int[]{y,x};
        }
    }
}