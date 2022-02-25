package interview.beginning;

/**
 * @author Abby
 * @date 2022/02/23
 * 搜索二维矩阵Ⅱ
 * 编写一个高效的算法来搜索x矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列,每列的元素从上到下升序排列
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 **/
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 20;
        int matrix2[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target2 = 5;
        int matrix3[][] = {{1,5}}, target3 = 5;
        int matrix4[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, target4 = 15;
        System.out.println(searchMatrix.searchMatrix(matrix,target));
    }
    /**
     * 法一：二叉排序树。从左下方或右上方开找
     * @param matrix 二维矩阵
     * @param target 目标数字
     * @return 是否存在目标数字
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
