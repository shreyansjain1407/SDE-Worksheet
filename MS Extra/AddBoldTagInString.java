class AddBoldTagInString {
    public String addBoldTag(String s, String[] words) {
        char[] sChar = s.toCharArray();
        char[] str = new char[s.length()];
        for(String word : words){
            int prevIndex = 0;
            while(s.indexOf(word, prevIndex) != -1){
                int curIndex = s.indexOf(word, prevIndex);
                for(int i = curIndex; i < curIndex + word.length(); i++){
                    str[i] = s.charAt(i);
                }
                prevIndex += word.length();
            }
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length){
            if(Character.isLetterOrDigit(str[i])){
                sb.append("<b>");
                while (i < str.length && Character.isLetterOrDigit(str[i])){
                    sb.append(str[i]);
                    i++;
                }
                sb.append("</b>");
                continue;
            }else{
                sb.append(s.charAt(i));
            }
            i++;
        }

        System.out.println(Arrays.toString(str));
        return sb.toString();
    }

    public static void main(String[] args) {
//        String str = "nrlneyieyjbiwvdmezfnhpqtbwxogypsbkwcygjxxpwfmjmdmisqtotmwsqamqxcyfrnfpglshknulqpstlpvrmburmmbomdybeveebfajjsrxjdorglremaczchkhsytttnwvfddwzfpxlycrkeheaktlbgyghihobvwcgnjwecipcufxewonddfmhuznicyhjffchcgdciqutbvppmtdqofhivijedkyrsdynhtjoleteyfjvoohkohrfefusayfaweyzmwyhoydeblohaiwvrlikdzzcwanturqdwosyrgxmeqyyspjpwuvhfqvheeogqltducgtupcrubqprnxzfctbawybqlnozpuuxqrwalvzahjjbsovhnpmacreqonnrncgdomefwkyeowiqoytdkseemedezmwzxwbgluboiihtbwkwcckdotsrohzkhkpxkzdivjcqpjurlenquzeuuzclsjylmyzmweholythsvqwlmfizfvqhntuvbkfxnhyjdwgjwtbyejbrijhaclnzhavbmggpomeqdysoapghiujnbdxbjqzvlnhwlozqzbzrwoolibjstcxdxfcefgeupubogydkvwpsepbbuxtnitrkahuotyejdktmowlilfuvvmkohlbpglhywygjeabolgkhbcdmicohfrxvlrxnjvdeestsajnmlvmzapgfkvuncnuskspybrzowtglufttfgbhbiziwpvttqvpywhuybuexazgwrkggkhydotiyamrujqtudmfjguuwqunawbncqfzfuxhswnoecivktsxazuegownfbyjowwvvgycziczmotepqnojacgjznxsrnonfevxkiybstoyrqbhrqydidkkixhyqvunldvzvslywxbpiwzqqsqswnfnwkbgdxmnsglrd";
//        String[] arr = {"nr","ne","ie","jb","wv","me","fn","pq","bw","og","ps","kw","yg","xx","wf","jm","mi","qt","tm","sq","mq","cy","rn","pg","sh","nu","qp","tl","vr","bu","mm","om","yb","ve","bf","jj","rx","do","gl","em","cz","hk","sy","tt","dd","zf"};
//        System.out.println(new Solution().addBoldTag(str, arr));;
//        System.out.println(new Solution().addBoldTag("aaabbcc", new String[]{"a","b","c"}));;
//        String x = "abcdabcd";
//        System.out.println(x.indexOf("abc", 5));
        String s1 = "<b>nr</b>l<b>ne</b>y<b>ie</b>y<b>jb</b>i<b>wv</b>d<b>mezfn</b>h<b>pqtbw</b>x<b>og</b>y<b>ps</b>b<b>kwcyg</b>j<b>xx</b>p<b>wf</b>m<b>jm</b>d<b>misqt</b>o<b>tm</b>w<b>sq</b>a<b>mq</b>x<b>cy</b>f<b>rn</b>f<b>pglshknu</b>l<b>qpstl</b>p<b>vr</b>m<b>bu</b>r<b>mm</b>b<b>om</b>d<b>yb</b>e<b>ve</b>e<b>bf</b>a<b>jj</b>s<b>rx</b>j<b>do</b>r<b>gl</b>r<b>em</b>a<b>cz</b>c<b>hk</b>h<b>sytt</b>tn<b>wv</b>f<b>dd</b>w<b>zf</b>pxlycrkeheak<b>tl</b>bg<b>yg</b>hihobvwcgnjwecipcufxewon<b>dd</b>fmhuzni<b>cy</b>hjffchcgdciqutbvppmtdqofhivijedkyrsdynhtjoleteyfjvoo<b>hk</b>ohrfefusayfaweyzmwyhoydeblohai<b>wvr</b>likdzzcwanturqdwo<b>sy</b>rgx<b>me</b>qyyspjpwuvhfqvhee<b>og</b>qltducgtupcrub<b>qprn</b>x<b>zf</b>ctbaw<b>yb</b>qlnozpuuxqrwalvzah<b>jjb</b>sovhnpmacreqon<b>nrn</b>cg<b>dome</b>fwkyeowiqoytdkse<b>eme</b>dezmwzxwb<b>gl</b>uboiiht<b>bwkw</b>cck<b>do</b>tsrohzk<b>hk</b>pxkzdivjc<b>qp</b>jurlenquzeuuzclsjylmyzmweholythsvqwlmfi<b>zf</b>vqhntuvbkfxnhyjdwgjwtbye<b>jb</b>rijhaclnzhavbmggp<b>ome</b>qdysoa<b>pg</b>hiujnbdxbjqzvlnhwlozqzbzrwoolibjstcxdxfcefgeupub<b>og</b>ydkvw<b>ps</b>epb<b>bu</b>xtnitrkahuotyejdk<b>tm</b>owlilfuvvmkohlb<b>pgl</b>hyw<b>yg</b>jeabolgkhbcd<b>mi</b>cohf<b>rx</b>vl<b>rx</b>njvdeestsajnmlvmza<b>pg</b>fkvunc<b>nu</b>sksp<b>yb</b>rzowt<b>gl</b>uf<b>tt</b>fgbhbiziwpv<b>tt</b>qvpywhu<b>ybu</b>exazgwrkggkhy<b>do</b>tiyamruj<b>qt</b>udmfjguuwqunawbncqf<b>zf</b>uxhswnoecivktsxazuegownfbyjow<b>wv</b>vgy<b>cz</b>i<b>cz</b>mote<b>pq</b>nojacgjznxs<b>rn</b>onfevxki<b>yb</b>stoyrqbhrqydidkkixhyqvunldvzvslywxbpiwzqq<b>sq</b>swn<b>fn</b>wkbgdxmns<b>gl</b>rd";
        String s2 = "<b>nr</b>l<b>ne</b>y<b>ie</b>y<b>jb</b>i<b>wv</b>d<b>mezfn</b>h<b>pqtbw</b>x<b>og</b>y<b>ps</b>b<b>kwcyg</b>j<b>xx</b>p<b>wf</b>m<b>jm</b>d<b>misqt</b>o<b>tm</b>w<b>sq</b>a<b>mq</b>x<b>cy</b>f<b>rn</b>f<b>pglshknu</b>l<b>qpstl</b>p<b>vr</b>m<b>bu</b>r<b>mm</b>b<b>om</b>d<b>yb</b>e<b>ve</b>e<b>bf</b>a<b>jj</b>s<b>rx</b>j<b>do</b>r<b>gl</b>r<b>em</b>a<b>cz</b>c<b>hk</b>h<b>syttt</b>n<b>wv</b>f<b>dd</b>w<b>zf</b>pxlycrkeheak<b>tl</b>bg<b>yg</b>hihobvwcgnjwecipcufxewon<b>dd</b>fmhuzni<b>cy</b>hjffchcgdciqutbvppmtdqofhivijedkyrsdynhtjoleteyfjvoo<b>hk</b>ohrfefusayfaweyzmwyhoydeblohai<b>wvr</b>likdzzcwanturqdwo<b>sy</b>rgx<b>me</b>qyyspjpwuvhfqvhee<b>og</b>qltducgtupcrub<b>qprn</b>x<b>zf</b>ctbaw<b>yb</b>qlnozpuuxqrwalvzah<b>jjb</b>sovhnpmacreqon<b>nrn</b>cg<b>dome</b>fwkyeowiqoytdkse<b>eme</b>dezmwzxwb<b>gl</b>uboiiht<b>bwkw</b>cck<b>do</b>tsrohzk<b>hk</b>pxkzdivjc<b>qp</b>jurlenquzeuuzclsjylmyzmweholythsvqwlmfi<b>zf</b>vqhntuvbkfxnhyjdwgjwtbye<b>jb</b>rijhaclnzhavbmggp<b>ome</b>qdysoa<b>pg</b>hiujnbdxbjqzvlnhwlozqzbzrwoolibjstcxdxfcefgeupub<b>og</b>ydkvw<b>ps</b>epb<b>bu</b>xtnitrkahuotyejdk<b>tm</b>owlilfuvvmkohlb<b>pgl</b>hyw<b>yg</b>jeabolgkhbcd<b>mi</b>cohf<b>rx</b>vl<b>rx</b>njvdeestsajnmlvmza<b>pg</b>fkvunc<b>nu</b>sksp<b>yb</b>rzowt<b>gl</b>uf<b>tt</b>fgbhbiziwpv<b>tt</b>qvpywhu<b>ybu</b>exazgwrkggkhy<b>do</b>tiyamruj<b>qt</b>udmfjguuwqunawbncqf<b>zf</b>uxhswnoecivktsxazuegownfbyjow<b>wv</b>vgy<b>cz</b>i<b>cz</b>mote<b>pq</b>nojacgjznxs<b>rn</b>onfevxki<b>yb</b>stoyrqbhrqydidkkixhyqvunldvzvslywxbpiwzqq<b>sq</b>swn<b>fn</b>wkbgdxmns<b>gl</b>rd";
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                System.out.println(i + " " + s1.charAt(i) + " " + s2.charAt(i));
        }
    }
}