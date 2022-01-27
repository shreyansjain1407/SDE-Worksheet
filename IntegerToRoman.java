class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] ids = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i = values.length - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && num > 0){
            if(num >= values[i]){
                int multiples = num/values[i];
                num %= values[i];
                sb.append(ids[i].repeat(multiples));
            }
            i--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().intToRoman(3999));
    }
}