package middle;

/**
 * @author Abby
 * @date 2022/03/08
 * 165.比较版本号
 * 输入：version1 = "1.01", version2 = "1.001"    输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"    输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 *
 * 输入：version1 = "0.1", version2 = "1.1"    输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 **/
public class CompareVersion {
    /**
     * 法一：字符串分割
     * 思路：先将字符串分割存于数组中，再逐次比较。将每个修订号转换为int型解决前导0的问题。
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 比较结果
     */
    public int compareVersion(String version1, String version2) {
        // 将版本号进行分割，并将修订号存入数组
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        // 每个修订号逐次比较
        for(int i = 0; i < ver1.length || i < ver2.length; i++) {
            // 每次比较完，将修订号清空并赋予初值0（初值0——如果版本号没有指定某个下标处的修订号，则该修订号视为 0）
            int x = 0, y = 0;
            if(i < ver1.length) {
                x = Integer.parseInt(ver1[i]);
            }
            if(i < ver2.length) {
                y = Integer.parseInt(ver2[i]);
            }
            if(x != y) {
                return (x > y) ? 1 : -1;
            }
        }
        return 0;
    }
    /**
     * 法二：双指针法
     * 思路：在分割版本号的同时解析计算出修订号，比较每段修订号
     */
    public int compareVersion2(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        char separator = '.';
        while(i < len1 || j < len2) {
            // 计算完每一段的修订号，值清空
            int x = 0, y = 0;
            while(i < len1 && version1.charAt(i) != separator) {
                x = x * 10 + version1.charAt(i) - '0';
                i++;
            }
            // 跳过分隔符
            i++;
            while(j < len2 && version2.charAt(j) != separator) {
                y = y * 10 + version2.charAt(j) - '0';
                j++;
            }
            // 跳过分隔符
            j++;
            if(x != y) {
                return (x > y) ? 1 : -1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion cv = new CompareVersion();
        System.out.println(cv.compareVersion("1.01", "1.0010"));
    }

}
