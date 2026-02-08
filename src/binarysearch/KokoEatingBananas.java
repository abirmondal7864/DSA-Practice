package binarysearch;
class KokoEatingBananas {

    /**
     * Finds the minimum eating speed k such that Koko can eat all bananas
     * within h totalHours using binary search on answer.
     */
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMax(piles); // maximum possible speed
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate speed

            if (canFinish(piles, h, mid)) {
                ans = mid;        // valid speed
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // need faster speed
            }
        }
        return ans;
    }

    /**
     * Checks if Koko can finish all piles within h totalHours
     * at eating speed k.
     */
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;

        for (int pile : piles) {
            // ceil(pile / k)
         totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }

    /**
     * Returns the maximum pile size.
     */
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
