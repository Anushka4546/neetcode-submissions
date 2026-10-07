class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        permute(nums, permutation, ans, visited, 0);
        return ans;
    }

    private void permute(int[] nums, List<Integer> permutation, List<List<Integer>> ans, boolean[] visited, int numbersPicked) {
        if(numbersPicked == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for(int idx = 0; idx < nums.length; idx++) {
            if(!visited[idx]) {
                visited[idx] = true;
                permutation.add(nums[idx]);
                permute(nums, permutation, ans, visited, numbersPicked + 1);
                permutation.remove(permutation.size() - 1);
                visited[idx] = false;
            }
        }
    }
}
