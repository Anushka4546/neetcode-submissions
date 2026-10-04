class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append("#");
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        } 

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '#') {
                int idx = str.indexOf('#', i + 1);
                 System.out.println(i + " " + idx);
                if(idx == -1) {
                    break;
                }
                try {
                    int len = Integer.parseInt(str.substring(i + 1, idx));
                    ans.add(str.substring(idx + 1, idx + len + 1));
                    i = idx + len;
                } catch(NumberFormatException ex) {
                    continue;
                }
            }
        }

        return ans;
    }
}
