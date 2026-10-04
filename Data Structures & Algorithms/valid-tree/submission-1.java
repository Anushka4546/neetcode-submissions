class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] par = new int[n];

        for(int i = 0; i < n; i++) {
            par[i] = i;
        }

        for(int[] e: edges) {
            int p1 = findPar(par, e[0]);
            int p2 = findPar(par, e[1]);

            if(p1 == p2) {
               return false;
            } else {
                par[p1] = p2;
            }
        }

        int countGroups = 0;
        for(int i = 0; i < par.length; i++) {
            if(par[i] == i) {
                countGroups++;
            }
        }

        return countGroups == 1;
    }

    private int findPar(int[] par, int u) {
        return par[u] == u ? par[u] : findPar(par, par[u]);
    }
}
