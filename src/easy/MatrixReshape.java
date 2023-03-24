package easy;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出全新的重塑矩阵；否则，输出原始矩阵。
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4  输出：[[1,2,3,4]]
 * @author abbylolo
 * @date 2023/02/21
 */
public class MatrixReshape {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape1(mat, 1, 4)));
    }

    /**
     * 采用一维数组过渡（不推荐
     * @param mat 原矩阵二维数组
     * @param r 重构的矩阵的行数
     * @param c 重构的矩阵的列数
     * @return 新矩阵（不满足则输出原矩阵）
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m * n != r * c) {
            return mat;
        }
        // 扁平化flatten处理原数组
        int[] nums = new int[m * n];
        for(int i = 0,k = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                nums[k] = mat[i][j];
                k++;
            }
        }
        // 重塑矩阵
        int[][] res = new int[r][c];
        for(int i = 0, k=0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                res[i][j] = nums[k];
                k++;
            }
        }
        return res;
    }

    /**
     * 直接转换
     * 时间复杂度O(rc) 空间复杂度O(1)
     */
    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m * n != r * c) {
            return mat;
        } else {
            int[][] ans = new int[r][c];
            for(int i = 0; i < m * n; i++) {
                ans[i / c][i % c] = mat[i / n][i % n];
            }
            return ans;
        }
    }
}
