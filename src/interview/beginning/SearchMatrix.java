package interview.beginning;

/**
 * @author Abby
 * @date 2022/02/23
 * 编写一个高效的算法来搜索x矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列,每列的元素从上到下升序排列
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 **/
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int matrix[][] = {{1,4,7,11,15}, {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 20;
        System.out.println(searchMatrix.searchMatrix(matrix,target));
    }
    /**
     * 法一：二叉排序树。从左下方或右上方开找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;
        while ( row <= matrix.length - 1 && column >= 0) {
            if(matrix[row][column] == target) {
                return true;
            } else if(matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
