class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length - 2;) {
            List<List<Integer>> subAns = twoSum(nums, i + 1, -nums[i]);

            for(List<Integer> sub: subAns) {
                sub.add(nums[i]);
                ans.add(sub);
            }

            if(subAns.size() > 0) {
                int num = nums[i];
                while(i < nums.length && nums[i] == num) {
                    i++;
                }
            } else {
                i++;
            }
        }

        return ans;
    }

    private List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        List<List<Integer>> twoSumAns = new ArrayList<>();
        int end = numbers.length - 1;

        while(start < end) {
            int num1 = numbers[start];
            int num2 = numbers[end];
            if(num1 + num2 == target) {
                
                List<Integer> sub = new ArrayList<>(List.of(num1, num2));
                twoSumAns.add(sub);
                
                while(start < numbers.length && numbers[start] == num1) {
                    start++;
                }

                while(end >= 0 && numbers[end] == num2) {
                    end--;
                }
            } else if(num1 + num2 > target) {
                end--;
            } else {
                start++;
            }
        }

        return twoSumAns;
    }
}
