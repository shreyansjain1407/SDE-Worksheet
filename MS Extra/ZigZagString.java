class ZigZagString {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 1)return s;
        Map<Integer, StringBuilder> rowMap = new HashMap<>();
        for(int i = 0; i < numRows; i++){
            rowMap.put(i, new StringBuilder());
        }
        int add = -1, rowNum = 0;
        for(int i = 0; i < s.length(); i++){
            rowMap.get(rowNum).append(s.charAt(i));
            if(rowNum == 0 || rowNum == numRows-1){
                add = -add;
            }
            rowNum += add;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            sb.append(rowMap.get(i).toString());
        }

        return sb.toString();
    }
}