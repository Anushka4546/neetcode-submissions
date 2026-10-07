class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        combinationSum(nums, subset, ans, target, 0, 0);
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
            combinationSum(nums, subset, ans, target, currSum + nums[idx], idx);
            subset.remove(subset.size() - 1);
        }
        combinationSum(nums, subset, ans, target, currSum, idx + 1);
    }
}
