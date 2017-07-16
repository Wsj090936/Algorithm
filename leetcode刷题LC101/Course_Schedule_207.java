package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
	which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
	For example:
	
	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	
	2, [[1,0],[0,1]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
	and to take course 0 you should also have finished course 1. So it is impossible.
	该题为拓扑排序
 */
public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] num = new int[numCourses];//用来存每一号课程的入度
    	List<Integer>[] list = new ArrayList[numCourses]; //邻接表，存有向边
    	for(int i = 0; i < numCourses;i++){//初始化邻接表
    		list[i] = new ArrayList<>();
    	}
    	for(int i = 0; i < prerequisites.length; i++){//将边存入邻接表
    		num[prerequisites[i][0]]++;//每遍历到该边一次，就使得入度加一
    		list[prerequisites[i][1]].add(prerequisites[i][0]);
    	}
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i = 0; i < numCourses;i++){//将入度为1的点入队列
    		if(num[i] == 0){
    			queue.add(i);
    		}
    	}
    	int count = 0;//计数值，统计遍历了多少个点，如果遍历完后和numCourses相同，则该图中不存在环
    	while(!queue.isEmpty()){
    		Integer point = queue.poll();//将队列的队头出队列
    		count++;
    		for(Integer each : list[point]){//从刚刚出队列的点开始遍历
    			num[each]--;//每遍历一个点就使得该点的入度减一
    			if(num[each] == 0){
    				queue.add(each);//入度为1就入队列
    			}
    		}
    	}
    	return count == numCourses;
    }
}
