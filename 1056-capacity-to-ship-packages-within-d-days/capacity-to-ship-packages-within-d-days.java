class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        // Find search range
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    boolean canShip(int[] weights, int days, int cap) {
        int day = 1, load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                day++;
                load = 0;
            }
            load += w;
        }

        return day <= days;
    }
}