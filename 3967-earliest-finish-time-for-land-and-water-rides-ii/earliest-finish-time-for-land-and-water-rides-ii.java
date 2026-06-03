import java.util.Arrays;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length, m = waterStartTime.length;

        int[] landEnd = new int[n];
        for (int i = 0; i < n; i++) landEnd[i] = landStartTime[i] + landDuration[i];

        int[] waterEnd = new int[m];
        for (int j = 0; j < m; j++) waterEnd[j] = waterStartTime[j] + waterDuration[j];

        Arrays.sort(landEnd);
        Arrays.sort(waterEnd);

        int[] landStartSorted = landStartTime.clone();
        int[] waterStartSorted = waterStartTime.clone();
        Arrays.sort(landStartSorted);
        Arrays.sort(waterStartSorted);

        int ans = Integer.MAX_VALUE;

        
        Integer[] wIdx = new Integer[m];
        for (int j = 0; j < m; j++) wIdx[j] = j;
        Arrays.sort(wIdx, (a, b) -> waterStartTime[a] - waterStartTime[b]);

        
        int lPtr = 0;
        boolean anyLandDone = false;

        for (int ji : wIdx) {
            int ws = waterStartTime[ji], wd = waterDuration[ji];
            
            while (lPtr < n && landEnd[lPtr] <= ws) {
                lPtr++;
                anyLandDone = true;
            }
            int bestStart;
            if (anyLandDone) {
                
                bestStart = ws;
            } else {
                
                bestStart = landEnd[0]; 
            }
            ans = Math.min(ans, bestStart + wd);
        }

       
        Integer[] lIdx = new Integer[n];
        for (int i = 0; i < n; i++) lIdx[i] = i;
        Arrays.sort(lIdx, (a, b) -> landStartTime[a] - landStartTime[b]);

        int wPtr = 0;
        boolean anyWaterDone = false;

        for (int li : lIdx) {
            int ls = landStartTime[li], ld = landDuration[li];
            while (wPtr < m && waterEnd[wPtr] <= ls) {
                wPtr++;
                anyWaterDone = true;
            }
            int bestStart;
            if (anyWaterDone) {
                bestStart = ls;
            } else {
                bestStart = waterEnd[0];
            }
            ans = Math.min(ans, bestStart + ld);
        }

        return ans;
    }
}