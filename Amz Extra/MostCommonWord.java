class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\\.?\\';,!]"," ").replaceAll("\\s+", " ").toLowerCase();
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();
        String output = "";
        int max = 0;
        for(String str : paragraph.split(" ")){
            if(!ban.contains(str)){
                freq.put(str, freq.getOrDefault(str, 0)+1);
                if(max < freq.get(str)){
                    output = str;
                    max = freq.get(str);
                }
            }
        }
        

        return output;
    }
}