import java.util.Arrays;

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
        int n = doc1.length(), m = doc2.length(), maxLen = 0;
        int[][] dp = new int[n+2][m+2];

        for (int i = 1; i <= n; i++) { // doc1
            for (int j = 1; j <= m; j++) { // doc2
                // matches --> +1
                if (doc1.charAt(i-1) == doc2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // does not match --> max of 2 prev
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
}
