public class QuickFindRunner {
    private static final int N = 10;
    private static final int[][] PAIRS = {
            {9, 0}, {3, 4}, {5, 8}, {7, 2}, {2, 1}, {5, 7}, {0, 3}, {4, 2}
    };

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(N);

        printHeader();
        int[] before = uf.ids();
        printRow("init", before, before);

        for (int[] pair : PAIRS) {
            int p = pair[0];
            int q = pair[1];
            uf.union(p, q);
            int[] after = uf.ids();
            printRow(p + "-" + q, before, after);
            before = after;
        }

        System.out.println();
        System.out.println("Each union(p, q) sets every entry equal to id[p] to id[q].");
        System.out.println("'*' marks entries changed by that step.");
    }

    private static void printHeader() {
        StringBuilder sb = new StringBuilder(String.format("%-6s", "pair"));
        for (int i = 0; i < N; i++) {
            sb.append(String.format("%4d", i));
        }
        System.out.println(sb);
        System.out.println("-".repeat(sb.length()));
    }

    private static void printRow(String label, int[] before, int[] after) {
        StringBuilder sb = new StringBuilder(String.format("%-6s", label));
        for (int i = 0; i < N; i++) {
            String cell = after[i] + (after[i] != before[i] ? "*" : "");
            sb.append(String.format("%4s", cell));
        }
        System.out.println(sb);
    }
}
