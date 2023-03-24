package easy;

/**
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25 (注：1 + 5 + 9 + 3 + 7 = 25)
 * @author abbylolo
 * @date 2023/02/21
 */
public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        DiagonalSum diagonalSum = new DiagonalSum();
        System.out.println(diagonalSum.diagonalSum(mat));
    }

    /**
     * 法一：逐行取数☑️
     * 思路：逐行遍历，记当前的行号为 i，对于一行我们把 (i,i) 位置和 (i,n−i−1) 加入答案。这样如果 n 是奇数的话，最中间的格子会被加入两次。所以 n 为奇数的时候，我们需要减掉矩阵最中心的那个值。
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param mat 正方形矩阵数组
     * @return 矩阵对角线元素的和
     */
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        for(int i = 0; i < len; i++) {
            sum += mat[i][i] + mat[i][len - 1 - i];
        }
        return sum - mat[len / 2][len / 2] * (len & 1);
    }

    /**
     * 法二：遍历法
     * 思路：遍历整个矩阵，如果当前坐标 (i,j) 满足 i=j 或者 i+j=n−1，就把当前的数字加入到答案中。
     * 时间复杂度：O(n^2) 空间复杂度：O(1)
     */
    public int diagonalSum1(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i == j || i + j == len - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
