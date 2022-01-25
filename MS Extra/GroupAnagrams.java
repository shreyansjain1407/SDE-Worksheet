class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap= new HashMap();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String cur = new String(c);
            if(strMap.containsKey(cur)){
                strMap.get(cur).add(str);
            }else{
                strMap.put(cur, new ArrayList<String>(){{add(str);}});
            }
        }
        return new ArrayList<>(strMap.values());
    }
}