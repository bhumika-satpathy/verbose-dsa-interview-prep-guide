package DP.Kanpsack;

public class MaximumPointsYouCanObtainFromCards {
    // --------- Gives TLE ----------------------------------------------------
    public int maxScore(int[] cardPoints, int k) {
        return maxScore(cardPoints, k, cardPoints.length - 1, 0);
    }

    int maxScore(int[] cards, int k, int endPoint, int startPoint) {
        if(endPoint - startPoint < 0 || k <= 0) {
            return 0;
        }

        return Math.max(cards[endPoint] + maxScore(cards, k - 1, endPoint - 1, startPoint),
                cards[startPoint] + maxScore(cards, k - 1, endPoint, startPoint + 1));
    }

    // --------- Modified Solution --------------------------------------------
    public int maxScore2(int[] cardPoints, int k) {
        int frontTotal = 0;
        int n = cardPoints.length;

        for(int i = 0; i < k; i++) {
            frontTotal += cardPoints[i];
        }

        int max = frontTotal;
        int rearTotal = 0;

        for(int i = k - 1; i >= 0; i--) {
            rearTotal += cardPoints[n - (k - i)];
            frontTotal -= cardPoints[i];

            int curr = frontTotal + rearTotal;
            max = Math.max(curr, max);
        }

        return max;
    }
}
