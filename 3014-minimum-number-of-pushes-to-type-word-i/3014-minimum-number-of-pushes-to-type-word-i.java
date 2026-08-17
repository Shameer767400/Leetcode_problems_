class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer += (i / 8) + 1;
        }

        return answer;
    }
}