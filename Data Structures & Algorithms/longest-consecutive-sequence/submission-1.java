class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> maxConsecutive = new HashMap<>();
        int ans = 1;

        for(int num: nums) {
            if(maxConsecutive.containsKey(num - 1)) {
                maxConsecutive.put(num, Math.max(maxConsecutive.get(num - 1) + 1, maxConsecutive.getOrDefault(num, 1)));
                ans = Math.max(ans, maxConsecutive.get(num));
            } else {
                maxConsecutive.put(num, 1);
            }
        }

        return ans;
    }
}
