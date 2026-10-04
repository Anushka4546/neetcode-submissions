class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length * matrix[0].length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            } else if(matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
