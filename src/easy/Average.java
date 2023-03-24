package easy;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组salary，数组里每个数都是 唯一的，其中salary[i] 是第i个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * 输入：salary = [4000,3000,1000,2000]  输出：2500.00000
 * @author abbylolo
 * @date 2023/02/15
 */
public class Average {
    public static void main(String[] args) {
        Average average = new Average();
        int[] salary = new int[]{6000,5000,4000,3000,2000,1000};
        System.out.println(average.average(salary));
    }

    public double average(int[] salary) {
        double sum = 0, min = salary[0], max = salary[0];
        for(int i = 0; i < salary.length; i++) {
            sum += salary[i];
            max = salary[i] > max ? salary[i] : max;
            min = salary[i] < min ? salary[i] : min;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
