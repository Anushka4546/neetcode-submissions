class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int ans = 0;

        for(int num: nums) {
            unique.add(num);
        }

        for(int num: unique) {
            if (!unique.contains(num - 1)) {
                int pseudo = num;
                int len = 1;
                while(unique.contains(pseudo + 1)) {
                    len++;
                    pseudo++;
                }

                ans = Math.max(len, ans);
            }
        }

        return ans;
    }
}
