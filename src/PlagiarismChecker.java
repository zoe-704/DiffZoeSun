/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Zoe Sun
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        // variables to find longest common sequence
        int n = doc1.length(), m = doc2.length(), maxLen = 0;
        int[][] dp = new int[n+2][m+2];
        // iterate through doc 1
        for (int i = 1; i <= n; i++) {
            // iterate through doc 2
            for (int j = 1; j <= m; j++) {
                // if characters at indexes match, increment by 1
                if (doc1.charAt(i-1) == doc2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // if characters do not match, take max of previous 2 subsequences
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                // update max length of longest common subsequences
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
