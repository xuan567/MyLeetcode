package BFS和DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode207课程表 {
    /*
    你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
    在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，
    其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai则必须先学习课程bi 。

    例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回true；否则，返回false 。

    示例 1：
    输入：numCourses = 2, prerequisites = [[1,0]]
    输出：true
    解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

    示例 2：
    输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    输出：false
    解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；
    并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

    * */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int cur:adjacency.get(pre)){
                if(--indegrees[cur]==0){
                    queue.add(cur);
                }
            }
        }
        return numCourses ==0;
    }
}
