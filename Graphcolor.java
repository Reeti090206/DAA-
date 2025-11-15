
public class Graphcolor {

    static int v = 4;
    static int c = 3;

    static int[][] a = {
        {0, 1, 1, 0},
        {1, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 1, 0}
    };

    static int[] col = new int[v];

    static boolean safe(int x, int y) {
        for (int i = 0; i < v; i++) {
            if (a[x][i] == 1 && col[i] == y) {
                return false;
            }
        }
        return true;
    }

    static boolean solve(int x) {
        if (x == v) {
            return true;
        }

        for (int i = 1; i <= c; i++) {
            if (safe(x, i)) {
                col[x] = i;

                if (solve(x + 1)) {
                    return true;
                }

                col[x] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (solve(0)) {
            for (int i = 0; i < v; i++) {
                System.out.println("Vertex " + i + " -> Color " + col[i]);
            }
        } else {
            System.out.println("No solution");
        }
    }
}
