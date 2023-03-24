package easy;

/**
 * 1232. 缀点成线
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]  输出：true
 * @author abbylolo
 * @date 2023/02/19
 */
public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
//        int[][] coordinates = {{0,0},{0,1},{0,-1}};
        CheckStraightLine checkStraightLine = new CheckStraightLine();
        System.out.println(checkStraightLine.checkStraightLine1(coordinates));
    }

    /**
     * 方法一：数学
     * 解析：将直线平移至经过原点,代入(x1,y1)得出直线方程，验证所有点是否满足直线方程：y=y1/x1 * x ➡ y1x-x1y=0
     * @param coordinates 数组
     * @return 是否能缀点成线
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        for(int[] point: coordinates) {
            point[0] -= x0;
            point[1] -= y0;
        }
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        for(int i = 2; i < coordinates.length; i++) {
            if(y1 * coordinates[i][0] - x1 * coordinates[i][1] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：两点式求出直线方程，点带入判断
     */
    public boolean checkStraightLine1(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        for(int i = 2; i < coordinates.length; i++) {
            if((coordinates[i][1] - y0) * (x1 - x0) - (y1 - y0) * (coordinates[i][0] - x0) != 0) {
                return false;
            }
        }
        return true;
    }

    //（斜率判断涉及除法，需考虑精度问题，故舍弃）
}
