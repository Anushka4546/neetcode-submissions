class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        combinationSum(candidates, subset, ans, target, 0, 0);
        return ans;
    }

    private void combinationSum(int[] nums, List<Integer> subset, List<List<Integer>> ans, int target, int currSum, int idx) {
        if(idx >= nums.length) {
            return;
        }

        if(currSum + nums[idx] <= target) {
            subset.add(nums[idx]);
            if(currSum + nums[idx] == target) {
                ans.add(new ArrayList<>(subset));
            }
            combinationSum(nums, subset, ans, target, currSum + nums[idx], idx + 1);
            subset.remove(subset.size() - 1);
        }
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }
        combinationSum(nums, subset, ans, target, currSum, nextIdx);
    }
}
