class RemoveAllOccurencesOfSubString {
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part) >= 0){
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}