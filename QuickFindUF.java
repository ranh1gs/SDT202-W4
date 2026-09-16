
public class QuickFindUF {
    private final int[] id;
    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
    public int[] ids() {
        return id.clone();
    }
}
