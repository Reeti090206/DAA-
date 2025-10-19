
class Solution {

    private int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    public int optimalSearchTree(int keys[], int freq[], int n) {
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                int sum = sum(freq, i, j);

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0)
                            + sum;

                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }

        return cost[0][n - 1];
    }
}
