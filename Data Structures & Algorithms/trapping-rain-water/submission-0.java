class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int ans = 0;

        for(int i = 0; i < height.length; i++) {
            int currH = height[i];

            while(st.peek() != -1 && height[st.peek()] <= currH) {
                int prevH = height[st.pop()];
                if(st.peek() == -1) {
                    break;
                }
                int w = i - st.peek() - 1;
                int h = Math.min(height[i], height[st.peek()]) - prevH;

                ans += h * w;
            }

            st.push(i);
        }

       return ans;
    }
}
