class Solution {
    public int minimumSwaps(int[] nums) {
        int totalZeros = 0;
        for(int x : nums) if (x == 0 ) totalZeros++;
         int zerosInPlace = 0;
        for(int i = nums.length - totalZeros; i < nums.length; i++){
            if(nums[i] == 0) zerosInPlace++;
        }
        return totalZeros - zerosInPlace;
        
    }
}