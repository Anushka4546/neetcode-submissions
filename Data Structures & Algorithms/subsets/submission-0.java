class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int idx) {
        if(idx == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        List<List<Integer>> recAns = subsets(nums, idx + 1);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> subAns: recAns) {
            List<Integer> newSet = new ArrayList<>(subAns);
            newSet.add(nums[idx]);
            ans.add(subAns);
            ans.add(newSet);
        }

        return ans;
    }
}
