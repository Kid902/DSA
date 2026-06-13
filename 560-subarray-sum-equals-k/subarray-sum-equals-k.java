class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int prefixsum =0;
        int count =0;

        for(int i =0; i< nums.length; i++){
            prefixsum += nums[i];

            if(mp.containsKey(prefixsum  -k)){
                count += mp.get(prefixsum  -k);
            }
            mp.put(prefixsum, mp.getOrDefault(prefixsum,0) +1);
        }
        return count;


        // int n=nums.length;
        // int count=0;

        // for (int i=0;i<n;i++){
        //     int sum=0;
        //     for (int j=i;j<n;j++){
        //         sum +=nums[j];
        //         if (sum == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}