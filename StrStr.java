class StrStr {
    public int myAtoi(String s) {
        double aux = 0;
        s = s.trim();
        s = s.split("\\.")[0];
        boolean isPositive = true;
        int i = 0;
        if(s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '+'){
            i++;
        }else if(s.charAt(0) == '-'){
            isPositive = false;
            i++;
        }
        while(i < s.length()){
            if(!Character.isDigit(s.charAt(i))){
                break;
            }
            aux = aux * 10 + (s.charAt(i) - '0');
            i++;
        }
        int output;
        if(aux > Integer.MAX_VALUE){
            if(isPositive)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }else{
            output = (int) aux;
        }
        return (isPositive)?output:output*-1;
    }
}