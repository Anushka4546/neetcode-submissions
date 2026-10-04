class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n+1];
        int ans = 0;

        for(int i = 0; i <= n; i++) {
            par[i] = i;
        }

        for(int[] e: edges) {
            int p1 = findPar(par, e[0]);
            int p2 = findPar(par, e[1]);

            if(p1 != p2) {
                par[p1] = p2;
            }
        }

        for(int i = 0; i < n; i++) {
            if(par[i] == i) {
                ans++;
            }
        }

        return ans;
    }

    private int findPar(int[] par, int u) {
        return par[u] == u ? par[u] : findPar(par, par[u]);
    }
}
