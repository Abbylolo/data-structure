package classic;

/**
 * @author Abby
 */

public class Pox {
    /**
     * for循环
     */
    public int getPox(int x,int n) {
        int result = 1;
        long startTime = System.nanoTime();
        if (n < 0) {
            System.out.println("ERROR:指数不能为负数");
            return -1;
        } else if(n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            result = result * x;
        }
        long endTime = System.nanoTime();
        System.out.println("程序1运行时间："+(endTime - startTime)+"ns");
        return result;
    }

    /**
     * 递归循环
     */
    public int getPox2(int x, int n) {
        if(n == 0) {
            return 1;
        } else {
            return x * getPox2(x, n-1);
        }
    }

    /**
     * 递归循环 -- 完全二叉树
     */
    public int getPox3(int x, int n) {
        if(n == 0) {
            return 1;
        } else if(x == 1){
            return x;
        } else if((n % 2) == 0) {
            return getPox3(x, n / 2) * getPox3(x, n / 2);
        } else {
            return getPox3(x, n / 2) * getPox3(x, n / 2) * x;
        }
    }

    /**
     * 递归循环 -- 完全二叉树
     */
    public int getPox4(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int t = getPox3(x, n / 2);
        if((n % 2) == 0) {
            return t * t;
        } else {
            return t * t * x;
        }
    }
}

class PoxTest {
    public static void main(String[] args) {
        Pox pox = new Pox();
        System.out.println("程序1运行结果："+pox.getPox(2,3));
        System.out.println("程序2运行结果："+pox.getPox2(2,3));
        System.out.println("程序3运行结果："+pox.getPox3(2,3));
        System.out.println("程序4运行结果："+pox.getPox4(2,3));
    }
}