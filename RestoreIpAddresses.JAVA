class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4)return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> addresses = new ArrayList<>();
        helper(s, sb, 0, addresses);
        return addresses;
    }

    public void helper(String s, StringBuilder sb, int dots, List<String> addresses){
        if(dots == 3){
            sb.append(s);
            if(verify(sb.toString())){
                addresses.add(sb.toString());
            }
            sb.setLength(sb.length() - s.length());
            return;
        }
        for(int i = 1; i <=s.length() && i <= 3; i++){
            sb.append(s.substring(0,i));
            sb.append(".");
            helper(s.substring(i), sb, dots+1, addresses);
            sb.setLength(sb.length() - (i+1));
        }
    }

    private boolean verify(String address) {
        String[] arr = address.split("\\.");
        if(arr.length < 4)return false;
        for(String part : arr){
            int x = 0;
            for(int i = 0; i < part.length(); i++){
                x = x*10 + (part.charAt(i) - '0');
                if(x > 255)return false;
            }
            if(x > 255 || x > 0 && part.charAt(0) == '0' || (x==0 && part.length()>1)){
                return false;
            }
        }
        return true;
    }
}