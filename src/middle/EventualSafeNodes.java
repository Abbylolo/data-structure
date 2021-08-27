package middle;

import java.util.*;

/**
 * 802.找到最终的安全状态（中等）
 * @author Abby
 */

class EventualSafeNodesTest {
    public static void main(String[] args) {
        // 实验数据——答案[2,4,5,6]、[4]
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};

        // 法一测试
        List<Integer> result11 = new EventualSafeNodes().eventualSafeNodes(graph);
        System.out.println("法一试验1："+result11.toString());
        List<Integer> result12 = new EventualSafeNodes().eventualSafeNodes(graph2);
        System.out.println("法一试验1："+result12.toString());

        // 法二测试
        List<Integer> result21 = new EventualSafeNodes2().eventualSafeNodes(graph);
        System.out.println("法二试验1："+result21.toString());
        List<Integer> result22 = new EventualSafeNodes2().eventualSafeNodes(graph2);
        System.out.println("法二试验2："+result22.toString());
    }
}

/**
 * 法一：类拓扑排序 —— 依次去掉没有出口的点及其边（此路不通）并加入安全序列，最终若有剩下的则必构成回环。（✔）
 * @author Abby
 */
public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}



/**
 * 法二：DFS+三色标记法 —— 对每个点深度优先搜索（递归实现）,逐点检查
 * 0-初值，未检查；1-检查中或不安全；2-检查完毕安全
 */
class EventualSafeNodes2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNode = new ArrayList<>();
        int length = graph.length;
        int[] color = new int[length];
        for(int order = 0; order<length; order++) {
            if(safe(graph, color, order)) {
                safeNode.add(order);
            }
        }
        return safeNode;
    }

    public boolean safe(int[][] graph, int[] color, int order) {
        if (color[order] > 0) {
            // 若该点已被检查过，则判断返回该点是否等于2（是否安全）
            return color[order] == 2;
        }
        color[order] = 1;
        for (int y : graph[order]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[order] = 2;
        return true;
    }
}

