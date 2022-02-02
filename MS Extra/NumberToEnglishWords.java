class NumberToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        // System.out.println(num);
        Map<Integer, String> words = new HashMap<>();
        words.put(1,"One");
        words.put(2, "Two");
        words.put(3, "Three");
        words.put(4, "Four");
        words.put(5, "Five");
        words.put(6, "Six");
        words.put(7, "Seven");
        words.put(8, "Eight");
        words.put(9, "Nine");
        words.put(10, "Ten");
        words.put(11, "Eleven");
        words.put(12, "Twelve");
        words.put(13, "Thirteen");
        words.put(14, "Fourteen");
        words.put(15, "Fifteen");
        words.put(16, "Sixteen");
        words.put(17, "Seventeen");
        words.put(18, "Eighteen");
        words.put(19, "Nineteen");
        words.put(20, "Twenty");
        words.put(30, "Thirty");
        words.put(40, "Forty");
        words.put(50, "Fifty");
        words.put(60, "Sixty");
        words.put(70, "Seventy");
        words.put(80, "Eighty");
        words.put(90, "Ninety");
        words.put(100, "Hundred");
        words.put(1000, "Thousand");
        words.put(1000000,"Million");
        StringBuilder sb = new StringBuilder();
        if(num >= 1000000000){
            int bil = num / 1000000000;
            sb.append(words.get(bil)).append(" ").append("Billion");
            num = num % 1000000000;
        }
        int div = 1000000;
        while(num > 0){
            getTens(num, sb, div, words);
            num %= div;
            div /= 1000;
        }
        return sb.toString().trim().replaceAll("\\s+", " ");
    }

    private void getTens(int cur, StringBuilder sb, int div, Map<Integer, String> words) {
        int curNum = cur / div;
        int curDiv = 100;
        while(curNum > 0){
            if((curNum / curDiv) != 0){
                sb.append(" ");

                if(curDiv == 10 && curNum >= 10 && words.containsKey(curNum)){
                    sb.append(" ").append(words.get(curNum));
                    break;
                }
                int carry = (curDiv == 10) ? curNum % curDiv : 0;
                int curWord = (curDiv == 10) ? curNum -= carry : curNum / curDiv;
                sb.append(words.get(curWord));
                if(curDiv == 100) {
                    sb.append(" ").append(words.get(curDiv));
                }
                if(curDiv == 10)curNum += carry;
                curNum %= curDiv;
                curDiv /= 10;
            }else{
                curDiv /= 10;
            }
        }
        if(cur >= div && div >= 1000) sb.append(" ").append(words.get(div));
    }
}