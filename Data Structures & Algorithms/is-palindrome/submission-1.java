class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(isAlphaNumeric(ch)) {
                sb.append(ch);
            }
        }

        if(sb.length() == 0) {
            return true;
        }

        s = sb.toString().toLowerCase();
        int midLen = s.length() / 2;

        for(int i = 0; i <= midLen; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(s.length() - i - 1);

            if(ch1 != ch2) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
