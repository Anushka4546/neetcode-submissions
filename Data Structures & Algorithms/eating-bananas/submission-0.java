class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = piles[0];

        for(int pile: piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while(maxSpeed > minSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            if(canFinish(piles, h, midSpeed)) {
                maxSpeed = midSpeed;
            } else {
                minSpeed = midSpeed + 1;
            }
        }

        return minSpeed;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int currH = 0;
        for(int pile: piles) {
            currH += (pile / speed);
            currH += (pile % speed) > 0 ? 1: 0; 
        }

        return currH <= h;
    }
}
