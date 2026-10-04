class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subboxes = new int[9];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                int num = Integer.parseInt(board[i][j] + "");
                int mask = (1 << num);

                if((rows[i] & mask) > 0) {
                    return false;
                }

                if((cols[j] & mask) > 0) {
                    return false;
                }

                if((subboxes[(i / 3) * 3 + (j / 3)] & mask) > 0) {
                    return false;
                }

                rows[i] = (rows[i] | mask);
                cols[j] = (cols[j] | mask);
                subboxes[(i / 3) * 3 + (j / 3)] = (subboxes[(i / 3) * 3 + (j / 3)] | mask);
            }
        }

        return true;
    }
}
