class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int INF = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        LinkedList<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    vis[i][j] = true;
                    que.addLast(i*m + j);
                }
            }
        }

        int dist = 0;

        while(que.size() > 0) {
            int siz = que.size();
            while(siz-- > 0) {
                int rn = que.removeFirst();
                int i = rn / m;
                int j = rn % m;

                for(int[] d: dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y] && grid[x][y] == INF) {
                        grid[x][y] = dist + 1;
                        vis[x][y] = true;
                        que.addLast(x*m + y);
                    }
                }
            }
            dist++;
        }
    }
}
