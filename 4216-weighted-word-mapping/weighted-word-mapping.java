class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int currentWeight =0;

            for (int i = 0; i< word.length();i++) {
                char ch = word.charAt(i);

                int index = ch - 'a';
                currentWeight += weights[index];
            }

            int modResult = currentWeight % 26;

            char mappedChar = (char) ('z' - modResult);

            result.append(mappedChar);
            
        }

        return result.toString();
        
    }
}