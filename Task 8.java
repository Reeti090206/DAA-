
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task8 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] p : paths) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];

            for (int nei : g[i]) {
                used[res[nei]] = true;
            }

            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    res[i] = c;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(res, 1, n + 1);
    }
}
