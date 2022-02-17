class SentencePangram {
    public boolean checkIfPangram(String sentence) {
        int count = 26;
        int[] arr = new int[26];
        for(char c : sentence.toCharArray()){
            arr[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0)return false;
        }
        
        return true;
    }
}